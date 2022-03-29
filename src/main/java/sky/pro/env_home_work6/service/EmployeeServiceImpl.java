package sky.pro.env_home_work6.service;

import org.springframework.stereotype.Service;
import sky.pro.env_home_work6.domain.Employee;
import sky.pro.env_home_work6.exception.EmployeeNotFoundException;
import sky.pro.env_home_work6.exception.EmployeeNotFoundException;
import sky.pro.env_home_work6.domain.Employee;
import java.util.Arrays;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    Employee[] employees =
            {new Employee("Иван", "Иванов"),
                    new Employee("Петр", "Петров"),
                    new Employee("Михаил", "Сидоров"),
                    new Employee("Максим", "Топорков")
            };
    @Override
    public String getEmployee(Integer number) {
        final Employee employee;
        if (number >= employees.length) {
            throw new EmployeeNotFoundException("Ошибка, номер сотрудника больше, чем сотрудников");
        }
        employee = employees[number];
        final String EmployeeDescription = ""
                + employee.getName() + " "
                + employee.getFamily();
        return EmployeeDescription;
    }
    @Override
    public String addArray(String firstname, String lastname) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName().equals(firstname) & employees[i].getFamily().equals(lastname)) {
                throw new EmployeeNotFoundException("Ошибка: Данный сотрудник есть в БД");
            }
        }
        int newSize = employees.length + 1;
        int indexNewElem = employees.length;
        Employee[] selectionArgs2 = new Employee[newSize];
        System.arraycopy(employees, 0, selectionArgs2, 0, employees.length);
        selectionArgs2[indexNewElem] = new Employee(firstname, lastname);
        employees = selectionArgs2;
        selectionArgs2 = null;
        return Arrays.toString(employees);
    }
    @Override
    public String deleteArray(String firstname, String lastname) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName().equals(firstname) || employees[i].getFamily().equals(lastname)) {
                employees[i] = null;
                Employee[] emp = new Employee[employees.length - 1];
                System.arraycopy(employees, 0, emp, 0, employees.length - 1);
                employees = emp;
                return "Удален" + firstname;
            }
        }
        throw new EmployeeNotFoundException("Ошибка: Данного сотрудника нет");
    }
    @Override
    public String searchArray(String firstname, String lastname) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName().equals(firstname) & employees[i].getFamily().equals(lastname)) {
                return employees[i].getName() + " " + employees[i].getFamily();
            }
        }
        throw new EmployeeNotFoundException("Ошибка: Данного сотрудника нет");
    }
}
