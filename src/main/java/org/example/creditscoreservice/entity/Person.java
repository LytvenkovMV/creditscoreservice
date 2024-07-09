package org.example.creditscoreservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inn")
    private Long inn;

    @Column(name = "full_name")
    private String fullname;

    @Column(name = "credit_score")
    private BigDecimal creditScore;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;
}
