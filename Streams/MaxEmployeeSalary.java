
import java.util.*;
import java.util.stream.Collectors;

class Employee 
{
    String name;
    double salary;

    // Constructor: initializes the employee's name and salary
    Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    // Getter method to return the employee's name
    public String getName()
    {
        return name;
    }

    // Getter method to return the employee's salary
    public double getSalary()
    {
        return salary;
    }
}

class Main 
{
    public static void main(String args[])
    {
        // Create a list of Employee objects
        List<Employee> list = Arrays.asList(
            new Employee("Arun", 45000),
            new Employee("Rohit", 36000),
            new Employee("Shivam", 23000),
            new Employee("Akash", 56000),
            new Employee("Shikha", 32000)
        );

        // Convert the list into a Stream
        // comparingDouble() compares employees based on their salary
        // max() returns the employee with the highest salary
        // orElse(null) returns null if the Stream is empty
        Employee ans = list.stream()
            .max(Comparator.comparingDouble(e -> e.getSalary()))
            .orElse(null);

        // Check whether an employee was found
        if (ans != null)
        {
            // Print the name and salary of the employee
            System.out.println(
                "Name : " + ans.getName() +
                " Salary : " + ans.getSalary()
            );
        }
    }
}
