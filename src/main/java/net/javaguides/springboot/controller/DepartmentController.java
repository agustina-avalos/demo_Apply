package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.DTOs.EmployeeDepartmentDTO;
import net.javaguides.springboot.service.DepartmentService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/department")
public class DepartmentController {


    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }




    @GetMapping("/employeesAndDep")
    public List<EmployeeDepartmentDTO> EmployeesWhitDepar(){

        return departmentService.getEmployeesWithDepartment();
    }
    

}
