package net.javaguides.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.DTOs.EmployeeDepartmentDTO;
import net.javaguides.springboot.repository.DepartmentRepository;
import net.javaguides.springboot.service.DepartmentService;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;


    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }


    @Override
    public List<Object[]> findEmployeesWithDepart() {
        return departmentRepository.findEmployeesWithDepart();
        

    }

    public List<EmployeeDepartmentDTO> getEmployeesWithDepartment() {
    List<Object[]> results = departmentRepository.findEmployeesWithDepart();
    List<EmployeeDepartmentDTO> employeesWithDepartment = new ArrayList<>();

    for (Object[] row : results) {
        Long id = ((Number) row[0]).longValue();
        String firstName = (String) row[1];
        String lastName = (String) row[2];
        String departmentName = (String) row[3];

        EmployeeDepartmentDTO dto = new EmployeeDepartmentDTO(id, firstName, lastName, departmentName);
        employeesWithDepartment.add(dto);
    }

    return employeesWithDepartment;
}




}
