package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "first_class_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirstClassUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date date;

    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personality_info_id")
    private PersonalityInfo personalityInfo;
}

