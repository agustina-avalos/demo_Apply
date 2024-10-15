package net.javaguides.springboot.service;

import java.util.List;


import net.javaguides.springboot.model.Employee;

public interface EmployeeService {

    Employee savEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
    void deteleEmployee(long id);
    Employee getEmployeeByEmail(String email);
    List<String> getAllEmails();

}
