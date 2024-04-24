package com.mftplus.salary.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class TimesheetPrimaryKeys implements Serializable {

    @Column(name = "work_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "person_employee_id")
    private Person employee;

}
