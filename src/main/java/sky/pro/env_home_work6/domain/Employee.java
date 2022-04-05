package sky.pro.env_home_work6.domain;

import java.util.Objects;

public class Employee {
    private String name;
    private String family;

    public Employee(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public String getName() {
        return this.name;
    }

    public String getFamily() {
        return family;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && family.equals(employee.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, family);
    }

    @Override
    public String toString() {
        return "Имя: " + this.name + " Фамилия: " + this.family;
    }

}
