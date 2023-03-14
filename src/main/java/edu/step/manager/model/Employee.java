package edu.step.manager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name" ,length = 50)
    private String name;
    @Column(name="surname", length = 50)
    private String surname;

    @Column(name = "salary")
    private Double salary;
    @Column(name="birthdate")
    private LocalDate birthdate;

    public Employee() {
    }

    public Employee(String name, String surname, Double salary, LocalDate birthdate) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.birthdate = birthdate;
    }

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(Integer id, String name, String surname, Double salary, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.birthdate = birthdate;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public double setSalary(Double salary) {
        this.salary = salary;
        return 0;
    }
}
