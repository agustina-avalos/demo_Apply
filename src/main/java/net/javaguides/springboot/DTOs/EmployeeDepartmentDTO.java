package net.javaguides.springboot.DTOs;




public class EmployeeDepartmentDTO {

    private Long idEmployee;
    private String nameEmployee;
    private String lastNameEmployee;
    private String nameDepartment;


    public EmployeeDepartmentDTO(Long id, String firstName, String lastName, String departmentName) {
        this.idEmployee = id;
        this.nameEmployee = firstName;
        this.lastNameEmployee = lastName;
        this.nameDepartment = departmentName;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }
    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }


    public String getNameEmployee() {
        return nameEmployee;
    }
    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }


    public String getLastNameEmployee() {
        return lastNameEmployee;
    }
    public void setLastNameEmployee(String lastNameEmployee) {
        this.lastNameEmployee = lastNameEmployee;
    }

    
    public String getNameDepartment() {
        return nameDepartment;
    }
    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }



}
