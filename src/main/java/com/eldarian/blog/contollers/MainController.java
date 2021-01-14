package com.eldarian.blog.contollers;

import com.eldarian.blog.models.Employee;
import com.eldarian.blog.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("emps", employeeRepository.findAll());
        model.addAttribute("defemp", new Employee());
        return "home";
    }

}