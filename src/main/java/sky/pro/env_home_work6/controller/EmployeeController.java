package sky.pro.env_home_work6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.env_home_work6.domain.Employee;
import sky.pro.env_home_work6.exception.EmployeeNotFoundException;
import sky.pro.env_home_work6.service.EmployeeService;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employee")
    public String Employee(@RequestParam("number") Integer number) {

        try {
            return employeeService.getEmployee(number);
        } catch (EmployeeNotFoundException e) {
            return "Попробуйте другой номер!";
        }
    }

    @GetMapping(path = "/employee/add")
    public String Employee(@RequestParam String firstname, @RequestParam String lastname) {
        Employee employee = new Employee(firstname, lastname);
        employeeService.addEmployee(employee);
        return "Сотрудник добавлен";
    }

    @GetMapping(path = "/employee/search")
    public String EmployeeSearch(@RequestParam String firstname, @RequestParam String lastname) {
        Employee employee = new Employee(firstname, lastname);
        return employeeService.searchEmployee(employee);
    }

    @GetMapping(path = "/employee/delete")
    public String EmployeeDel(@RequestParam String firstname, @RequestParam String lastname) {
        Employee employee = new Employee(firstname, lastname);
        return employeeService.deleteEmployee(employee);
    }


}