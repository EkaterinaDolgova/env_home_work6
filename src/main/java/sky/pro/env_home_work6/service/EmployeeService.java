package sky.pro.env_home_work6.service;

import org.springframework.stereotype.Service;
import sky.pro.env_home_work6.domain.Employee;

import java.util.Map;

@Service
public interface EmployeeService {
    String getEmployee(Integer number);

    void addEmployee(Employee employees);

    String searchEmployee(Employee employee);

    String deleteEmployee(Integer id);

    Map<Integer, Employee> getEmployeeList();

}
