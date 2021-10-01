package com.example.employees_api.models;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    // @Column(name = "first_name")
    private String first_name;
    private String last_name;
    private char gender;
    private Date birth_date;
    private Date hire_date;
    private boolean active;
    private String photo;
    @Column(name="department_id") //ESTE ES EL NOMBRE REAL EN LA BASE DE DATOS, Si no se pone esta línea entonces se creará un atributo con  el nombre siguiente
    private int departmentid;       //AQUÍ NO SE COLOCÓ EL _ (GUIÓ BAJO) POR QUE EL ORM NO LOS ACEPTA ASÍ

    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public Date getBirth_date() {
        return birth_date;
    }
    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }
    public Date getHire_date() {
        return hire_date;
    }
    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public int getDepartmentid() {
        return departmentid;
    }
    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }
    

}