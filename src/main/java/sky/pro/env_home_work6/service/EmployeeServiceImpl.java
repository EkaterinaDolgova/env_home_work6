package sky.pro.env_home_work6.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import sky.pro.env_home_work6.domain.Employee;
import sky.pro.env_home_work6.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = new ArrayList(List.of(
            new Employee("Иван", "Иванов"),
            new Employee("Петр", "Петров"),
            new Employee("Михаил", "Сидоров"),
            new Employee("Максим", "Топорков")
    ));

    @Override
    public List<Employee> getEmployeeList() {
        return employees;
    }

    @Override
    public String getEmployee(Integer number) {
        Employee employee;
        if (number >= employees.size()) {
            throw new EmployeeNotFoundException("Ошибка, номер сотрудника больше, чем сотрудников");
        }
        employee = employees.get(number);
        String EmployeeDescription = ""
                + employee.getName() + " "
                + employee.getFamily();
        return EmployeeDescription;
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public String searchEmployee(Employee employee) {
        if (employees.contains(employee)) {
            return "Данный сотрудник найден";
        }
        throw new EmployeeNotFoundException("Ошибка, сотрудника не найден");
    }

    @Override
    public String deleteEmployee(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
            return " Данный сотрудник удален";
        }
        throw new EmployeeNotFoundException("Ошибка, сотрудника не найден");
    }
}
