package com.mftplus.salary.service;

import com.mftplus.salary.model.Timesheet;
import com.mftplus.salary.model.TimesheetPrimaryKeys;

import java.util.List;
import java.util.Optional;

public interface TimesheetService {

    void save(Timesheet timesheet) throws Exception;
    void edit(Timesheet timesheet) throws Exception;
    void logicalRemove(TimesheetPrimaryKeys id) throws Exception;

    List<Timesheet> findAll() throws Exception;
    List<Timesheet> findAllByDeletedFalse() throws Exception;

    Optional<Timesheet> findById(TimesheetPrimaryKeys id) throws Exception;
}
