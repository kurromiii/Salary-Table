package com.mftplus.salary.service.impl;

import com.mftplus.salary.model.Timesheet;
import com.mftplus.salary.model.TimesheetPrimaryKeys;
import com.mftplus.salary.repository.TimesheetRepository;
import com.mftplus.salary.service.TimesheetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimesheetServiceImpl implements TimesheetService {

    private final TimesheetRepository timesheetRepository;

    public TimesheetServiceImpl(TimesheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }

    @Override
    public void save(Timesheet timesheet) throws Exception {
        timesheetRepository.save(timesheet);
    }

    @Override
    public void edit(Timesheet timesheet) throws Exception {
        timesheetRepository.save(timesheet);
    }

    @Override
    public void logicalRemove(TimesheetPrimaryKeys id) throws Exception {
        timesheetRepository.logicalRemove(id);
    }

    @Override
    public List<Timesheet> findAll() throws Exception {
        return timesheetRepository.findAll();
    }

    @Override
    public List<Timesheet> findAllByDeletedFalse() throws Exception {
        return timesheetRepository.findAllByDeletedFalse();
    }

    @Override
    public Optional<Timesheet> findById(TimesheetPrimaryKeys id) throws Exception {
        return timesheetRepository.findById(id);
    }
}
