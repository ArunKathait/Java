import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {

        // Original string containing duplicate characters.
        String str = "abcasdacb";

        // Step 1: Convert the string into an IntStream of character values.
        // Example: 'a' -> 97, 'b' -> 98, 'c' -> 99, etc.
        List<Character> ans = str.chars()

            // Step 2: Convert each integer character value into a Character.
            // Example: 97 -> 'a', 98 -> 'b'.
            .mapToObj(c -> (char) c)

            // Step 3: Remove duplicate characters.
            // Keeps the first occurrence of each character
            // and preserves the original encounter order.
            .distinct()

            // Step 4: Collect the remaining characters into a List.
            .collect(Collectors.toList());

        // Step 5: Print the list of distinct characters.
        System.out.println(ans);
    }
}
