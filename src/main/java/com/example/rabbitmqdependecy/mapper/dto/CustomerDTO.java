package com.example.dto;

import com.example.model.Customer;
import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    // Diğer özellikler

    public static CustomerDTO fromEntity(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        // Diğer özelliklerin atamaları

        return dto;
    }

    public Customer toEntity() {
        Customer customer = new Customer();
        customer.setId(this.id);
        customer.setName(this.name);
        customer.setEmail(this.email);
        // Diğer özelliklerin atamaları

        return customer;
    }
}
