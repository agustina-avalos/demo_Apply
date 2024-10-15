package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.DTOs.EmployeeDepartmentDTO;

public interface DepartmentService {


    List<Object[]> findEmployeesWithDepart();
    List<EmployeeDepartmentDTO>getEmployeesWithDepartment();

}
