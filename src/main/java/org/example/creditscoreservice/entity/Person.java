package org.example.creditscoreservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullname;

    @Column(name = "credit_score")
    private BigDecimal creditScore;

    @Column(name = "phones")
    private String phones;

    @Column(name = "emails")
    private String emails;
}
