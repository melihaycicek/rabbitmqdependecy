package com.example.mapper;

import com.example.dto.CustomerDTO;
import com.example.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO toDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setDate(customer.getDate());
        customerDTO.setUsername(customer.getUsername());
        customerDTO.setPersonalityInfo(customer.getPersonalityInfo());
        return customerDTO;
    }

    public Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setDate(customerDTO.getDate());
        customer.setUsername(customerDTO.getUsername());
        customer.setPersonalityInfo(customerDTO.getPersonalityInfo());
        return customer;
    }
}
