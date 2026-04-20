
import java.util.*;

class Main {
    public static void main(String[] args) {

        // Creating a list of salaries (contains duplicate values)
        List<Integer> salaries = Arrays.asList(1000,2000,3000,4000,5000,1000,2000,5000,9000);

        // Stream pipeline to get top 3 highest salaries
        List<Integer> top3 = salaries.stream()   // Convert list into stream

                .distinct()   // Remove duplicate values
                              // [1000,2000,3000,4000,5000,9000]

                .sorted(Comparator.reverseOrder())  
                              // Sort in descending order
                              // [9000,5000,4000,3000,2000,1000]

                .limit(3)     // Take first 3 elements (top 3 salaries)
                              // [9000,5000,4000]

                .toList();    // Convert stream back to List

        // Print the result
        System.out.println(top3);
    }
}
