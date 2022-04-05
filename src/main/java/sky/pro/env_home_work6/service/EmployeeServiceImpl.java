package sky.pro.env_home_work6.service;

import org.springframework.stereotype.Service;
import sky.pro.env_home_work6.domain.Employee;
import sky.pro.env_home_work6.exception.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<Integer, Employee> employees;
    Integer nextId = 0;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
        employees.put(getNextId(), new Employee("Иван", "Иванов"));
        employees.put(getNextId(), new Employee("Петр", "Петров"));
        employees.put(getNextId(), new Employee("Владимир", "Иванченко"));
        employees.put(getNextId(), new Employee("Степан", "Казанцев"));
    }

    private Integer getNextId() {
        Integer result = nextId;
        nextId = nextId + 1;
        return result;
    }


    @Override
    public Map<Integer, Employee> getEmployeeList() {
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
        employees.put(getNextId(), employee);
    }

    @Override
    public String searchEmployee(Employee employee) {
        if (employees.containsValue(employee)) {
            return "Данный сотрудник найден";
        }
        throw new EmployeeNotFoundException("Ошибка, сотрудник не найден");
    }

    @Override
    public String deleteEmployee(Integer id) {
        if (employees.containsKey(id)) {
            employees.remove(id);
            return " Данный сотрудник удален";

        }
        throw new EmployeeNotFoundException("Ошибка, сотрудника не найден");
    }

}
