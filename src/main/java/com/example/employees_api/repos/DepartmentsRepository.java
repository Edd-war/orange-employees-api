package com.example.employees_api.repos;

//import java.util.List;

import com.example.employees_api.models.Departments;

import org.springframework.data.repository.CrudRepository;
public interface DepartmentsRepository extends CrudRepository<Departments, Integer>{
    //List<Employee> findByFirst_Name(String first_name);
    //List<Employee> findByLast_Name(String last_name);
}





