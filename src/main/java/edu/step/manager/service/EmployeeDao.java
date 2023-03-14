package edu.step.manager.service;

import edu.step.manager.model.Employee;
import edu.step.manager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDao {
    @Autowired
    EmployeeRepository repository;

    public List<Employee> findAll(){
        return repository.findAll();
    }

    public Employee findById(int id) {
        Optional<Employee> byId = repository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    public  List<Employee> findByName(String name){
        return repository.findAllByNameEquals(name);
    }

    public void create(List<Employee> employees) {
        repository.saveAll(employees);
    }

    public void create(Employee employee) {
        repository.save(employee);
    }

    public Employee update(Employee employee) {
        Optional<Employee> employee1 = repository.findById(employee.getId());
        if(employee1.isPresent()) {
            Employee employee2 = employee1.get();
            employee2.setName(employee.getName());
            employee2.setSalary(employee.setSalary(12.22));
            repository.save(employee2);
        }else {
            System.out.println("N-am putut gasi obiectul cu id " + employee.getId());
        }
        return employee;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
