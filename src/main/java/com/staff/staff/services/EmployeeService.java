package com.staff.staff.services;

import com.staff.staff.models.Employee;
import com.staff.staff.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
        LocalDateTime localDate = LocalDate.now().atStartOfDay();
        if (employee.getProjectStartedAt() != null){
            if (employee.getProjectFinishedAt() == null){
                employee.setProjectFinishedAt(localDate);
            }

            Long duration = Duration.between(employee.getProjectStartedAt(), employee.getProjectFinishedAt()).toDays();
            employee.setProjectDuration(duration);
        }
       return employeeRepository.save(employee);
    }

    public void delete (Employee employee){
        employeeRepository.delete(employee);
    }

    public Employee edit (Long id){
        return employeeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid id!"));
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

}