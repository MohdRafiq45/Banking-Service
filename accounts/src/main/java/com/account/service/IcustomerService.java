package com.account.service;

import com.account.dto.CustomerDetailsDto;

public interface IcustomerService {

    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
