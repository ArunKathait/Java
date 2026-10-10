

import java.util.*;
import java.util.stream.Collectors;

// Employee class represents one employee
class Employee {
    int id;
    String name;
    String department;

    // Constructor initializes employee details
    Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Returns the department of an employee
    public String getDepartment() {
        return department;
    }

    // Returns the employee's name when the object is printed
    @Override
    public String toString() {
        return name;
    }
}

class Main {
    public static void main(String[] args) {

        // Create a list containing five Employee objects
        List<Employee> list = Arrays.asList(
            new Employee(1, "Arun", "SDE"),
            new Employee(2, "Rahul", "IT"),
            new Employee(3, "Neha", "SDE"),
            new Employee(4, "Tripti", "IT"),
            new Employee(5, "Arushi", "Law")
        );

        // Convert the list into a Stream.
        // Group employees using their department as the key.
        // Each department maps to a List<Employee>.
        Map<String, List<Employee>> mp = list.stream()
            .collect(
                Collectors.groupingBy(
                    e -> e.getDepartment()
                )
            );

        // Iterate over each map entry:
        // department = key
        // employee = list of employees in that department
        mp.forEach((department, employee) -> {

            // Print the department and its employees.
            // toString() displays each employee's name.
            System.out.println(
                "Department: " + department + " Name: " + employee
            );
        });
    }
}
