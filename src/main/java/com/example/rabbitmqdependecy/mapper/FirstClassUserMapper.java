package com.example.mapper;

import com.example.dto.FirstClassUserDTO;
import com.example.model.FirstClassUser;

public class FirstClassUserMapper {
    public static FirstClassUserDTO toDTO(FirstClassUser firstClassUser) {
        return FirstClassUserDTO.fromEntity(firstClassUser);
    }

    public static FirstClassUser toEntity(FirstClassUserDTO firstClassUserDTO) {
        return firstClassUserDTO.toEntity();
    }
}
