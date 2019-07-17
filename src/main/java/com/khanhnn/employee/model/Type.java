package com.khanhnn.employee.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameType;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    public Type() {
    }

    public Type(String nameType) {
        this.nameType = nameType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
