
import java.util.*;

class Main {
    public static void main(String[] args) {

        // Step 1: Create a list of integers.
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // Step 2: Convert the list into a Stream<Integer>.
        // Step 3: Convert Integer objects into primitive int values.
        // Step 4: Calculate the average using average().
        // average() returns OptionalDouble because the list may be empty.
        double ans = list.stream()
                         .mapToInt(Integer::intValue)
                         .average()
                         .orElse(0.0);

        // Step 5: Print the average.
        System.out.println(ans); // Output: 3.0
    }
}
