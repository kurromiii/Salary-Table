package com.mftplus.salary.service;

import com.mftplus.salary.model.Person;
import com.mftplus.salary.model.Timesheet;

import java.sql.Date;
import java.util.List;

public interface TimesheetService {

    void save(Timesheet timesheet) throws Exception;
    void edit(Timesheet timesheet) throws Exception;
    void logicalRemove(Date date, Person person) throws Exception;

    List<Timesheet> findAll() throws Exception;
    List<Timesheet> findAllByDeletedFalse() throws Exception;

//    Optional<Timesheet> findById(TimesheetPrimaryKeys id) throws Exception;
}
