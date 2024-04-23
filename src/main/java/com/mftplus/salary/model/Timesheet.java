package com.mftplus.salary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.sql.Timestamp;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "timesheetEntity")
@Table(name = "timesheet_tbl")
@IdClass(TimesheetPrimaryKeys.class)
public class Timesheet {

    //timesheet

    //this table needs two primary keys : 1)person 2)date
//    @EmbeddedId
//    private TimesheetPrimaryKeys id;
    @Id
    private Date date;

    @Id
    @ManyToOne
    private Person employee;

    //manager = the one that is responsible for filling this table
    //todo : shouldn't this be of type of user?
//    @ToString.Exclude
//    @ManyToOne
//    @JoinColumn(name = "person_manager_id")
//    private Person manager;

    //زمان شروع - موظفی
    @Column(name = "regular_time_in")
    private Timestamp regularTimeIn;

    //زمان پایان - موظفی
    @Column(name = "regular_time_out")
    private Timestamp regularTimeOut;

    //زمان شروع - اضافه کاری
    @Column(name = "over_time_in")
    private Timestamp overTimeIn;

    //زمان پایان - اضافه کاری
    @Column(name = "over_time_out")
    private Timestamp overTimeOut;

    //todo : I dont know the required type for signature
    @Column(name = "employee_signature", unique = true, length = 30)
    private String employeeSignature;

    @Column(name = "manager_signature", unique = true, length = 30)
    private String managerSignature;

    @Column(name = "timesheet_deleted")
    private Boolean deleted = false;

}