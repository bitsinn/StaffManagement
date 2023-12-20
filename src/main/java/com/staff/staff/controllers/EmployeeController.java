package com.staff.staff.controllers;

import com.staff.staff.models.Employee;
import com.staff.staff.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String allEmployees(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("employee", new Employee());
        return "homePage";
    }

    @PostMapping("/")
    @Validated
    public String addEmployee( @ModelAttribute @Valid Employee employee, BindingResult result, Model model){
        if (result.hasErrors()){
            return "homePage";
        }
        employeeService.save(employee);
        model.addAttribute("employee", employeeService.findAll());
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String delete (@PathVariable Long id, @ModelAttribute Employee employee, Model model){
        employeeService.delete(employee);
        model.addAttribute("employee", employee);
        return "redirect:/";
    }

}
