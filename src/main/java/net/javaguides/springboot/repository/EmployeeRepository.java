package net.javaguides.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

    @Query(value= "SELECT * FROM employees WHERE email = :email", nativeQuery = true)
    Optional<Employee> findByEmail(@Param("email") String email);


    @Query(value = "SELECT email FROM employees", nativeQuery = true)
    List<String> getAllEmails();


}
