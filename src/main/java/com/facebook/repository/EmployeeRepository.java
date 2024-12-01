package com.facebook.repository;

import com.facebook.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    // JpaRepository baghun geil tula kontehi CRUD operations karaychet ka..?
//    like insert,update,delete
}
