package com.eldarian.blog.contollers;

import com.eldarian.blog.models.Employee;
import com.eldarian.blog.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @Autowired
    private EmployeeRepository repo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("emps", repo.findAll());
        model.addAttribute("defemp", new Employee());
        model.addAttribute("creating", true);
        return "home";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(defaultValue = "null") String id, Model model) {
        if(!id.equals("null")) {
            model.addAttribute("emps", repo.findAll());
            model.addAttribute("defemp", repo.findById(Long.parseLong(id)).get());
            model.addAttribute("creating", false);
            return "home";
        } else
            return "redirect:/";
    }

    @PostMapping("/insert")
    public void insert(
            @RequestParam(defaultValue = "null") String firstName,
            @RequestParam(defaultValue = "null") String lastName,
            @RequestParam(defaultValue = "null") String phoneNumber,
            @RequestParam(defaultValue = "null") String salary,
            @RequestParam(defaultValue = "null") String address,
            @RequestParam(defaultValue = "null") String expirience,
            HttpServletResponse httpServletResponse) {
        Employee emp = new Employee();
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setPhoneNumber(phoneNumber);
        emp.setSalary(Integer.parseInt(salary));
        emp.setAddress(address);
        emp.setExpirience(Integer.parseInt(expirience));
        repo.save(emp);
        httpServletResponse.setHeader("Location", "/");
        httpServletResponse.setStatus(302);
    }

    @PostMapping(value = "/update")
    public void update(
            @RequestParam(defaultValue = "null") String id,
            @RequestParam(defaultValue = "null") String firstName,
            @RequestParam(defaultValue = "null") String lastName,
            @RequestParam(defaultValue = "null") String phoneNumber,
            @RequestParam(defaultValue = "null") String salary,
            @RequestParam(defaultValue = "null") String address,
            @RequestParam(defaultValue = "null") String expirience,
            HttpServletResponse httpServletResponse) {
        Employee emp = repo.findById(Long.parseLong(id)).get();
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setPhoneNumber(phoneNumber);
        emp.setSalary(Integer.parseInt(salary));
        emp.setAddress(address);
        emp.setExpirience(Integer.parseInt(expirience));
        repo.save(emp);
        httpServletResponse.setHeader("Location", "/");
        httpServletResponse.setStatus(302);
    }

    @GetMapping("/delete")
    public void delete(
            @RequestParam(defaultValue = "null") String id,
            HttpServletResponse httpServletResponse) {
        repo.deleteById(Long.parseLong(id));
        httpServletResponse.setHeader("Location", "/");
        httpServletResponse.setStatus(302);
    }

}