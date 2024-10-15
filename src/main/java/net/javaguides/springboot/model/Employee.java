package net.javaguides.springboot.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



import lombok.Data;


@Data // lombok genera las funciones para la clase mas generales como los get and setters
@Entity  //para decirle a la clase que es una entidad
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;



    @ManyToOne
    @JoinColumn(name = "department_id")  // Este es el nombre de la columna en la base de datos
    private Department department;

}
