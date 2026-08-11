
import java.util.*;

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Arun", "IT", 60000),
                new Employee(2, "Rahul", "HR", 45000),
                new Employee(3, "Amit", "IT", 75000),
                new Employee(4, "Priya", "Finance", 50000),
                new Employee(5, "Neha", "HR", 80000)
        );

        List<Employee> ans = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .toList();

        ans.forEach(System.out::println);
    }
}
