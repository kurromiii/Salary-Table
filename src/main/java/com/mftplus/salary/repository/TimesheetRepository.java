package com.mftplus.salary.repository;

import com.mftplus.salary.model.Timesheet;
import com.mftplus.salary.model.TimesheetPrimaryKeys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, TimesheetPrimaryKeys> {

    List<Timesheet> findAllByDeletedFalse();

    @Transactional
    @Modifying
    @Query("update timesheetEntity oo set oo.deleted=true where oo.date=:date and oo.employee.id=:id")
    void logicalRemove(Date date, Long id);

    Optional<Timesheet> findByDateAndEmployeeId(Date date, Long id);
}
