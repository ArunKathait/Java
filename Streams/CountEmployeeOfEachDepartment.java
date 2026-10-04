
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;

    // Constructor: initializes the employee's details.
    Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}

class Main {
    public static void main(String[] args) {

        // Step 1: Create a list of employees.
        List<Employee> list = Arrays.asList(
            new Employee(1, "Arun", "IT"),
            new Employee(2, "Rahul", "HR"),
            new Employee(3, "Simran", "SDE"),
            new Employee(4, "Astha", "HR"),
            new Employee(5, "Kathait", "IT")
        );

        // Step 2: Group employees by department and count them.
        // list.stream() creates a stream of Employee objects.
        Map<String, Long> mp = list.stream()
            .collect(Collectors.groupingBy(

                // First argument:
                // Select the department as the grouping key.
                // Employees with the same department go into the same group.
                e -> e.department,

                // Second argument:
                // Count the number of employees in each group.
                Collectors.counting()
            ));

        // Step 3: Print each department and its employee count.
        // department = map key
        // count      = map value
        mp.forEach((department, count) ->
            System.out.println(department + " : " + count)
        );
    }
}
