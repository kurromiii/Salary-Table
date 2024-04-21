package com.mftplus.salary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ShiftEntity")
@Table(name = "shift_tbl")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shift_seq")
    @SequenceGenerator(name = "shift_seq")
    @Column(name = "id", nullable = false)
    private Long id;

}