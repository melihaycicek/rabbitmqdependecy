package com.example.dto;

import com.example.model.BusinessAccount;
import lombok.Data;

@Data
public class BusinessAccountDTO {
    private Long id;
    private String name;
    private String email;
    // Diğer özellikler

    public static BusinessAccountDTO fromEntity(BusinessAccount businessAccount) {
        BusinessAccountDTO dto = new BusinessAccountDTO();
        dto.setId(businessAccount.getId());
        dto.setName(businessAccount.getName());
        dto.setEmail(businessAccount.getEmail());
        // Diğer özelliklerin atamaları

        return dto;
    }

    public BusinessAccount toEntity() {
        BusinessAccount businessAccount = new BusinessAccount();
        businessAccount.setId(this.id);
        businessAccount.setName(this.name);
        businessAccount.setEmail(this.email);
        // Diğer özelliklerin atamaları

        return businessAccount;
    }
}
