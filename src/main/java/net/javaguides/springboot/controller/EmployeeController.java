package net.javaguides.springboot.controller;

import java.net.http.HttpClient;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/create")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
    
        return new ResponseEntity<Employee>(employeeService.savEmployee(employee), HttpStatus.CREATED);
    }


    @GetMapping
    public List<Employee> getEmployees() {
        System.out.println("getEmployees() fue llamado");

        return employeeService.getAllEmployees();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") long id) {

        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Employee> getEmployeeByEmail (@RequestParam("email") String email) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/emails")
    public List<String> getAllEmails() {
        return employeeService.getAllEmails();
    }
    
    
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updatEmployee(@RequestBody Employee employee, @PathVariable("id") long id) {
        
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable("id") long id){
        employeeService.deteleEmployee(id);
        return new ResponseEntity<String>("Employee delete successfully", HttpStatus.OK);
        
    }
}
