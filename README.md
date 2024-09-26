# Bank Service Microservices Project

This project is a **Banking Web Application** built using **Spring Boot** and follows a **microservices architecture**. It consists of separate microservices for handling accounts, loans, and cards, with an API gateway for routing and authentication.

## Table of Contents
- [Overview](#overview)
- [Microservices Architecture](#microservices-architecture)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Overview

This project demonstrates a modular approach to building a banking service using microservices. Each microservice is independently developed, deployed, and scaled, allowing for easier maintenance and flexibility. The API Gateway handles routing, load balancing, and security.

### Features:
- **Account Service**: Manage user accounts.
- **Loans Service**: Handle loans data.
- **Cards Service**: Manage customer card information.
- **Gateway Server**: Route requests to respective microservices and handle authentication.

## Microservices Architecture

The project is split into the following services:

1. **Account Microservice**:
   - Manages customer account information.
   - Provides account details and transaction history.

2. **Loans Microservice**:
   - Manages customer loan information.
   - Provides loan details and repayment history.

3. **Cards Microservice**:
   - Manages customer credit/debit card information.
   - Provides card details and spending history.

4. **API Gateway**:
   - Handles routing of client requests to respective microservices.
   - Provides a single entry point to all services.
   - Manages security and rate limiting.

## Technologies Used

- **Spring Boot** for microservices development.
- **Spring Cloud Gateway** for API Gateway.
- **Spring Data JPA** for database interactions.
- **MySQL/PostgreSQL** as the database.
- **Eureka** for service discovery (Optional, if used).
- **Feign Client** for internal service-to-service communication.
- **Docker** for containerization.
- **Maven** for dependency management.

## Prerequisites

Before you begin, ensure you have the following installed:

- Java 17+
- Maven
- Docker (Optional)
- MySQL or PostgreSQL

## Running the Application

To run the application locally:

1. Clone the repository:
   ```bash
   git clone https://github.com/MohdRafiq/bank-service-microservices.git
   cd bank-service-microservices
