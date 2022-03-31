package sky.pro.env_home_work6.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import sky.pro.env_home_work6.domain.Employee;
import sky.pro.env_home_work6.exception.EmployeeNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList(List.of(
            new Employee("Иван", "Иванов"),
            new Employee("Петр", "Петров"),
            new Employee("Михаил", "Сидоров"),
            new Employee("Максим", "Топорков")
    ));


    @Override
    public String listEmployee() {
        Gson gson = new Gson();
        String jsonCartList =gson.toJson(employees);
        return jsonCartList;
    }

    @Override
    public String getEmployee(Integer number) {
        final Employee employee;
        if (number >= employees.size()) {
            throw new EmployeeNotFoundException("Ошибка, номер сотрудника больше, чем сотрудников");
        }
        employee = employees.get(number);
        final String EmployeeDescription = ""
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
        return "Данный сотрудник не найден";
    }

    @Override
    public String deleteEmployee(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
            return " Данный сотрудник удален";
        }
        return "Данный сотрудник не найден";
    }
}
