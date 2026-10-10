**************************************************DEPARTMENT + EMPLOYEE NAME********************************************
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;

    // Constructor: initializes employee details when an Employee object is created.
    Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Override toString() so printing an Employee object returns its name.
    // For example, instead of Employee@1a2b3c, it prints "Arun".
    @Override
    public String toString() {
        return name;
    }
}

class Main {
    public static void main(String[] args) {

        // Step 1: Create a list containing Employee objects.
        List<Employee> list = Arrays.asList(
            new Employee(1, "Arun", "IT"),
            new Employee(2, "Rahul", "HR"),
            new Employee(3, "Simran", "SDE"),
            new Employee(4, "Astha", "HR"),
            new Employee(5, "Kathait", "IT")
        );

        // Step 2: Convert the list into a Stream to process employees.
        // groupingBy() groups employees based on the department field.
        //
        // e -> e.department means:
        // Take each Employee object (e) and use its department as the key.
        //
        // Employees with the same department are collected into one List.
        // The result is a Map where:
        // Key   = Department name (String)
        // Value = List of Employee objects belonging to that department.
        Map<String, List<Employee>> mp = list.stream()
            .collect(Collectors.groupingBy(
                e -> e.department
            ));

        // Step 3: Iterate through each entry in the Map.
        // department represents the key, such as "IT" or "HR".
        // employees represents the List<Employee> for that department.
        mp.forEach((department, employees) ->

            // Print the department and its employees.
            // Java prints the list using each Employee's toString() method.
            // Since toString() returns the name, only employee names appear.
            System.out.println(department + " : " + employees)
        );
    }
}

********************************************IF WE WANT DEPARTMENT AND THEIR EMPLOYEE COUNT***************************


import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;

    // Constructor: initializes each employee's details
    Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Returns the department of the current employee
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
            new Employee(3, "Arushi", "Law"),
            new Employee(4, "Preeti", "IT"),
            new Employee(5, "Anusha", "SDE")
        );

        // Convert the list into a Stream and group employees by department.
        // groupingBy() creates a group for each distinct department.
        // counting() counts the employees belonging to each group.
        // Result: department -> number of employees.
        Map<String, Long> mp = list.stream()
            .collect(Collectors.groupingBy(
                e -> e.getDepartment(),  // Grouping key
                Collectors.counting()    // Count employees in each group
            ));

        // Iterate through the resulting map.
        // department represents the key.
        // count represents the number of employees in that department.
        mp.forEach((department, count) ->
            System.out.println(department + ": " + count)
        );
    }
}

********************************************MAX SALARY IN EACH DEPARTMENT**********************************************

    
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    // Constructor to initialize employee details
    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getter to return employee salary
    public double getSalary() {
        return salary;
    }

    // Getter to return employee department
    public String getDepartment() {
        return department;
    }

    // Getter to return employee name
    public String getName() {
        return name;
    }
}

class Main {
    public static void main(String[] args) {

        // Create a list of employees with their department and salary
        List<Employee> list = Arrays.asList(
            new Employee(1, "Arun", "SDE", 150000),
            new Employee(2, "Rahul", "IT", 50000),
            new Employee(3, "Nikhil", "HR", 40000),
            new Employee(4, "Akash", "SDE", 70000),
            new Employee(5, "Preeti", "HR", 60000)
        );

        // Convert the employee list into a Stream
        // Group employees according to their department
        // Within each department, find the employee with maximum salary
        Map<String, Optional<Employee>> mp = list.stream()
            .collect(Collectors.groupingBy(
                e -> e.getDepartment(), // Department is the grouping key

                // Find the employee with the highest salary in each group
                Collectors.maxBy(
                    Comparator.comparingDouble(e -> e.getSalary())
                )
            ));

        // Iterate over the map entries
        // department = department name
        // employee = Optional containing the highest-paid employee
        mp.forEach((department, employee) -> {

            // If an employee exists, retrieve the Employee object
            employee.ifPresent(e ->

                // Print department, employee name, and salary
                System.out.println(
                    department + " : " + e.getName()
                    + " : " + e.getSalary()
                )
            );
        });
    }
}
