package sky.pro.env_home_work6.service;

import org.springframework.stereotype.Service;
import sky.pro.env_home_work6.domain.Employee;
import sky.pro.env_home_work6.exception.EmployeeNotFoundException;
import sky.pro.env_home_work6.domain.Employee;
import java.util.Arrays;

@Service
public interface EmployeeService {
    public String getEmployee  (Integer number);
    public String addArray(String firstname, String lastname);
    public String deleteArray(String firstname, String lastname);
    public String searchArray(String firstname, String lastname);
}
