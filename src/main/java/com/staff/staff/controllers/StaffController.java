package com.staff.staff.controllers;

import com.staff.staff.models.Staff;
import com.staff.staff.services.StaffService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Controller
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/")
    public String allEmployees(Model model){
        List<Staff> staffList = staffService.findAll();
        model.addAttribute("Staff", staffList);
        model.addAttribute("staff", new Staff());
        return "homePage";
    }

    @PostMapping("/")
    @Validated
    public String addEmployee( @ModelAttribute @Valid Staff staff, BindingResult result, Model model){
        if (result.hasErrors()){
            return "homePage";
        }
        staffService.save(staff);
        model.addAttribute("staff", staffService.findAll());
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String delete (@ModelAttribute Staff staff, Model model){
        staffService.delete(staff);
        model.addAttribute("staff", staff);
        return "redirect:/";
    }

    @GetMapping("/project")
    public String projectPage(Model model) {
        List<Staff> employees = staffService.findEmployeesWhoWorkedTogether();
        model.addAttribute("staff", employees);
        return "filterPage";
    }
}