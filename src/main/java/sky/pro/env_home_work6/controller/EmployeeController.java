package sky.pro.env_home_work6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.env_home_work6.domain.Employee;
import sky.pro.env_home_work6.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/list")
    public Map<Integer, Employee> printEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @GetMapping(path = "/employee")
    public String employeeS(@RequestParam("number") Integer number) {
        return employeeService.getEmployee(number);
    }

    @GetMapping(path = "/employee/add")
    public String employeeAdd(@RequestParam String firstname, @RequestParam String lastname) {
        Employee employee = new Employee(firstname, lastname);
        employeeService.addEmployee(employee);
        return "Сотрудник добавлен";
    }

    @GetMapping(path = "/employee/search")
    public String employeeSearch(@RequestParam String firstname, @RequestParam String lastname) {
        Employee employee = new Employee(firstname, lastname);
        return employeeService.searchEmployee(employee);
    }

    @GetMapping(path = "/employee/delete")
    public String employeeDel(@RequestParam Integer id) {
        // Employee employee = new Employee(id);
        return employeeService.deleteEmployee(id);
    }


}