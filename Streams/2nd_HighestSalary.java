
import java.util.*;

class Main {
    public static void main(String[] args) {

        // Creating a list of salaries (contains duplicates as well)
        List<Integer> salaries = Arrays.asList(1000,2000,3000,4000,5000,1000,2000,5000,9000);
      
        // Stream pipeline to find 2nd highest salary
        Optional<Integer> secondHighest = salaries.stream()   // Convert list into stream

                .distinct()   // Remove duplicate values
                              // [1000,2000,3000,4000,5000,9000]

                .sorted(Comparator.reverseOrder())  
                              // Sort in descending order
                              // [9000,5000,4000,3000,2000,1000]

                .skip(1)      // Skip the first element (highest salary → 9000)
                              // Remaining: [5000,4000,3000,2000,1000]

                .findFirst(); // Get the first element → 5000 (2nd highest)

        // Optional is used because result may or may not exist
        // ifPresent() prints value only if it is present
        secondHighest.ifPresent(System.out::println);
    }
}
