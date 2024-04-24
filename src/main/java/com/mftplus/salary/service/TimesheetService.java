package com.mftplus.salary.service;

import com.mftplus.salary.model.Timesheet;
import com.mftplus.salary.model.TimesheetPrimaryKeys;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface TimesheetService {

    void save(Timesheet timesheet) throws Exception;
    void edit(Timesheet timesheet) throws Exception;
    void logicalRemove(Date date, Long id) throws Exception;

    List<Timesheet> findAll() throws Exception;
    List<Timesheet> findAllByDeletedFalse() throws Exception;

    Optional<Timesheet> findById(TimesheetPrimaryKeys id) throws Exception;
    Optional<Timesheet> findByDateAndEmployeeId(Date date, Long id) throws Exception;
}
