package edu.step.manager.repository;

import edu.step.manager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByNameEquals(String name);
    List<Employee> findAllBySalaryGreaterThan(Double salary);
    List<Employee> findAllByNameEqualsAndSalaryLessThan(String name, Double salary);

}
