package com.mftplus.salary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "personEntity")
@Table(name = "person_tbl")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(name = "person_seq" ,allocationSize = 1,initialValue = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "p_name", length = 30)
    private String name;

    @Column(name = "p_family", length = 30)
    private String lastname;

    @Column(name = "p_username", length = 30 ,unique = true)
    private String username;

    @Column(name = "p_password", length = 30)
    private String password;

    @Column(name = "salary_deleted")
    private Boolean deleted = false;

}