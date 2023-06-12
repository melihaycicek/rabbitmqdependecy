package com.example.mapper;

import com.example.dto.BusinessAccountDTO;
import com.example.model.BusinessAccount;

public class BusinessAccountMapper {
    public static BusinessAccountDTO toDTO(BusinessAccount businessAccount) {
        return BusinessAccountDTO.fromEntity(businessAccount);
    }

    public static BusinessAccount toEntity(BusinessAccountDTO businessAccountDTO) {
        return businessAccountDTO.toEntity();
    }
}
