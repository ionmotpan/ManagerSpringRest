package edu.step.manager.controller;

import edu.step.manager.model.Employee;
import edu.step.manager.model.EmployeeDTO;
import edu.step.manager.service.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Serviciu REST
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeDao dao;

    //Get all - GET
    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){

        return ResponseEntity.ok(dao.findAll());
    }
    //Create - POST
    @PostMapping
    public ResponseEntity create(@RequestBody EmployeeDTO dto){
        dao.create(new Employee(dto.getName(), dto.getSurname(), dto.getSalary(), dto.getBirthdate()));
        return ResponseEntity.ok().build();
    }
    //Update - PUT
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable(value = "id") int userId,@RequestBody EmployeeDTO dto) {
        dao.update(new Employee(userId,dto.getName(),dto.getSurname(),dto.getSalary(),dto.getBirthdate()));
        return ResponseEntity.ok("Item updated succesfully !");
    }
    //Delete - DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int userId) {
        dao.delete(userId);
        return ResponseEntity.ok().build();
    }


}