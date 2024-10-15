package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.javaguides.springboot.model.Department;


public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query(value= "SELECT e.id as id_employee, e.first_name, e.last_name, d.name as department_name " +
                "FROM employees e INNER JOIN department d " +
                 "ON e.department_id = d.id", nativeQuery = true)
    List<Object[]> findEmployeesWithDepart();




}
