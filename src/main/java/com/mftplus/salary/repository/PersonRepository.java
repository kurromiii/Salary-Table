package com.mftplus.salary.repository;

import com.mftplus.salary.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    @Transactional
    @Modifying
    @Query("update personEntity oo set oo.deleted=true where oo.id=:id")
    void logicalRemove(Long id);

    List<Person> findAllByDeletedFalse();

    List<Person> findByNameOrFamily(String name, String family);
}
