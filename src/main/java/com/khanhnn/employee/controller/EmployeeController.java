package com.khanhnn.employee.controller;

import com.khanhnn.employee.model.Employee;
import com.khanhnn.employee.model.Type;
import com.khanhnn.employee.service.EmployeeService;
import com.khanhnn.employee.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TypeService typeService;

    @RequestMapping("/")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView("homepage");
        return modelAndView;
    }

    @ModelAttribute("types")
    public Page<Type> typeEmployee(Pageable pageable) {
        return typeService.findAll(pageable);
    }

    @GetMapping("/employees")
    public ModelAndView list(@RequestParam("search") Optional<String> search, @PageableDefault(size = 5) Pageable pageable) {
        Page<Employee> employees;
        ModelAndView modelAndView = new ModelAndView("employee/list");

        if (search.isPresent()) {
            employees = employeeService.findAllByNameContainingOrEmployeeCodeContaining(search.get(), search.get(), pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/create-employee")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public String saveCustomer(@Valid @ModelAttribute("employee") Employee employee
            , BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAllAttributes(bindingResult.getModel());
            return "employee/create";
        } else {
            employeeService.save(employee);
            model.addAttribute("employee", employee);
            return "redirect:/employees";
        }
    }

    @GetMapping("/edit-employee/{id}")
    public ModelAndView showEditForm(@Valid @PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        modelAndView.addObject("employee", employee);
        return modelAndView;

    }

    @PostMapping("/edit-employee")
    public String update(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/view-employee/{id}")
    public ModelAndView view(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("employee/view");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/delete-employee/{id}")
    public String delete(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            employeeService.remove(id);
        }
        return "redirect:/employees";
    }
}
