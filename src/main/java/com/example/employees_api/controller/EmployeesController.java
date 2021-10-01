package com.example.employees_api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.employees_api.models.Departaments;

import com.example.employees_api.models.Employee;
import com.example.employees_api.repos.DepartamentsRepository;
import com.example.employees_api.repos.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeesController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartamentsRepository departamentsRepository;

    @GetMapping("/")
    public String hello()
    {
        return "Hello World";
    }

    @GetMapping("/employees")
    public @ResponseBody Iterable<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    @GetMapping("/departaments")
    public @ResponseBody Iterable<Departaments> getAllDepartaments()
    {
        return departamentsRepository.findAll();
    }


    
    //Metodo para mostrar los empleados de acuerdo a su departamento <<Se tuvo que cambiar el campo de employee en la base de datos sin el "_"
   @GetMapping("/departaments/employees")
    public ResponseEntity <List<Employee>> getAllEmployees(@RequestParam(required = false) Integer departament_id)
    {
        List<Employee> employees = new ArrayList<Employee>();

        if(departament_id == null)
            employeeRepository.findAll().forEach(employees::add);
        else
            employeeRepository.findBydepartamentid(departament_id).forEach(employees::add);
        
        if (employees.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }



    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeebyId(@PathVariable("id") Integer id)
    {
        Optional<Employee> employeeData = employeeRepository.findById(id);
        if(employeeData.isPresent())
        {
            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
