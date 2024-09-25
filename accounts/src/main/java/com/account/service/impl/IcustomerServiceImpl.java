package com.account.service.impl;

import com.account.dto.AccountsDto;
import com.account.dto.CardsDto;
import com.account.dto.CustomerDetailsDto;
import com.account.dto.LoansDto;
import com.account.entity.Accounts;
import com.account.entity.Customer;
import com.account.exception.ResourceNotFoundException;
import com.account.mapper.AccountsMapper;
import com.account.mapper.CustomerMapper;
import com.account.repository.AccountsRepository;
import com.account.repository.CustomerRepository;
import com.account.service.IcustomerService;
import com.account.service.client.CardsFeignClient;
import com.account.service.client.LoansFeignClient;
import org.springframework.http.ResponseEntity;

public class IcustomerServiceImpl implements IcustomerService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(()->
            new ResourceNotFoundException("customer","mobilNumber",mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(()->
             new ResourceNotFoundException("Account","customerId",customer.getCustomerId().toString())
        );
        CustomerDetailsDto customerDetailsDto= CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts,new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity= loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity= cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}
