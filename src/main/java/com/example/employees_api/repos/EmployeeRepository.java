package com.example.employees_api.repos;

import java.util.List;
//import java.util.Optional;

import com.example.employees_api.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
    List<Employee> findBydepartamentid(Integer departament_id);
    //Optional<Employee> findByemployeeid(Integer id);
    //List<Employee> findByLast_Name(String last_name);
}
