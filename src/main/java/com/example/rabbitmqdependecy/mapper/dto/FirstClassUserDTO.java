package com.example.dto;

import com.example.model.FirstClassUser;
import lombok.Data;

@Data
public class FirstClassUserDTO {
    private Long id;
    private String name;
    private String email;
    // Diğer özellikler

    public static FirstClassUserDTO fromEntity(FirstClassUser firstClassUser) {
        FirstClassUserDTO dto = new FirstClassUserDTO();
        dto.setId(firstClassUser.getId());
        dto.setName(firstClassUser.getName());
        dto.setEmail(firstClassUser.getEmail());
        // Diğer özelliklerin atamaları

        return dto;
    }

    public FirstClassUser toEntity() {
        FirstClassUser firstClassUser = new FirstClassUser();
        firstClassUser.setId(this.id);
        firstClassUser.setName(this.name);
        firstClassUser.setEmail(this.email);
        // Diğer özelliklerin atamaları

        return firstClassUser;
    }
}
