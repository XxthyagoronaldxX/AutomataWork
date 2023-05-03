package com.tajad.automata_work.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "user_tb")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "random_value", nullable = false)
    private double randomValue;
}
