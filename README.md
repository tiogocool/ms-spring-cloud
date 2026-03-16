# Spring Boot Microservices (Customer + Billing)

Microservices architecture using Spring Boot, Spring Cloud, Eureka, OpenFeign and H2 database.

## Overview

This project is a **microservices architecture** built with **Spring Boot** and **Spring Cloud**.
It demonstrates how to build distributed systems using service discovery and inter-service communication.

The system contains two main microservices:

* **Customer Service** – manages customers
* **Billing Service** – manages invoices and communicates with the customer service

---

## Architecture

```
                 +----------------------+
                 |      API Gateway     |
                 |    (Spring Cloud)    |
                 +----------+-----------+
                            |
             -----------------------------------
             |                                 |
      +-------------+                  +-------------+
      | Customer    |<------Feign----->| Billing     |
      | Service     |                  | Service     |
      +-------------+                  +-------------+
           

                     
              +--------------+
              |  Eureka      |
              | Discovery    |
              +--------------+

                     
         
Database: H2 (in-memory)
```

---

## Technologies Used

* Java 17
* Spring Boot
* Spring Cloud
* Spring Data JPA
* API Gateway
* OpenFeign
* Eureka Discovery Server
* H2 Database
* Lombok
* MapStruct
* Swagger / OpenAPI

---

## Microservices

### Customer Service

Responsible for managing customer data.

Main features:

* Create customer
* Get customer by ID
* List customers

### Billing Service

Responsible for managing invoices.

Main features:

* Create invoice
* Retrieve invoices
* Call Customer Service using OpenFeign to retrieve customer information

---

## Service Communication

Billing Service communicates with Customer Service using **OpenFeign**.

Example:

```java
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    Customer getCustomer(@PathVariable String id);
}
```

---

## Running the Project

### 1. Start Eureka Server

Run the discovery service.

### 2. Start Customer Service

```
mvn spring-boot:run
```

### 3. Start Billing Service

```
mvn spring-boot:run
```

---

## API Documentation

Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

---

## H2 Database Console

```
http://localhost:8080/h2-console
```

JDBC URL:

```
jdbc:h2:mem:billing-DB
```

---

## Project Structure

```
microservices-project
│
├── discovery-service
│
├── customer-service
│   ├── controllers
│   ├── services
│   ├── repositories
│   └── entities
│
└── billing-service
    ├── controllers
    ├── services
    ├── repositories
    ├── entities
    ├── dto
    └── mappers
```

---

## Author

Developed as a Spring Boot microservices learning project.
