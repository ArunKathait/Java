
import java.util.*;

class Main {
    public static void main(String[] args) {

        // Step 1: Create a list containing five integers.
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // Step 2: Convert the list into a Stream<Integer>.
        // Step 3: mapToInt(Integer::intValue) converts each
        // Integer object into a primitive int.
        // Step 4: sum() adds all the primitive int values.
        int ans = list.stream()
                      .mapToInt(Integer::intValue)
                      .sum();

        // Step 5: Print the total sum.
        System.out.println(ans); // Output: 15
    }
}
