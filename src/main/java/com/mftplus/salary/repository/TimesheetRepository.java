package com.mftplus.salary.repository;

import com.mftplus.salary.model.Person;
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

    //todo : rethink for findById
    @Query("select t from timesheetEntity t where t.id.date = ?1 and t.id.employee.id = ?2")
    Optional<Timesheet> findById_DateAndId_Employee_Id(Date date, long id);

    List<Timesheet> findById_DateAndDeletedFalse(Date date);

    List<Timesheet> findById_EmployeeAndDeletedFalse(Person employee);

    List<Timesheet> findAllByDeletedFalse();

    @Transactional
    @Modifying
    @Query("update timesheetEntity oo set oo.deleted=true where oo.id=:id")
    void logicalRemove(TimesheetPrimaryKeys id);
}
