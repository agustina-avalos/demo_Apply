package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    @Override
    public Employee savEmployee(Employee employee) {
      return employeeRepository.save(employee);
    }


    @Override
    public List<Employee> getAllEmployees() {
      return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id){
      Optional<Employee> employee = employeeRepository.findById(id);
      		if(employee.isPresent()) {
      			return employee.get();
      		}else {
      			throw new ResourceNotFoundException("Employee", "Id", id);
    		}
    }


    @Override
    public Employee getEmployeeByEmail(String email){
      Optional<Employee> employee = employeeRepository.findByEmail(email);
      if(employee.isPresent()){
        return employee.get();
      }else{
        throw new ResourceNotFoundException("Employee", "email", email);
      }
    }


    @Override
    public Employee updateEmployee(Employee employee, long id){

      Employee exisEmployee = employeeRepository.findById(id).orElseThrow( 
        () ->  new ResourceNotFoundException("Employee", "Id", id));

        exisEmployee.setFirstName(employee.getFirstName());
        exisEmployee.setLastName(employee.getLastName());
        exisEmployee.setEmail(employee.getEmail());

        employeeRepository.save(exisEmployee);
        return exisEmployee;
    }



    @Override
    public void deteleEmployee(long id){

      Employee exisEmployee = employeeRepository.findById(id).orElseThrow( 
        () ->  new ResourceNotFoundException("Employee", "Id", id));

        employeeRepository.deleteById(exisEmployee.getId());
      
    }


    @Override
    public List<String> getAllEmails(){
      List<String> emails = employeeRepository.getAllEmails();
      return emails;
    
    }


}
