package com.mftplus.salary.repository;

import com.mftplus.salary.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Long> {

    @Transactional
    @Modifying
    @Query("update salaryEntity oo set oo.deleted=true where oo.id=:id")
    void logicalRemove(Long id);

    List<Salary> findAllByDeletedFalse();

}