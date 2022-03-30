package sky.pro.env_home_work6.service;

import org.springframework.stereotype.Service;
import sky.pro.env_home_work6.domain.Employee;
import sky.pro.env_home_work6.exception.EmployeeNotFoundException;
import sky.pro.env_home_work6.domain.Employee;
import java.util.Arrays;

@Service
public interface EmployeeService {
    public String getEmployee  (Integer number);
    public void  addEmployee(Employee employees);
    String searchEmployee(Employee employee);
    String deleteEmployee(Employee employee);

}
