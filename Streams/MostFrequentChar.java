

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Input string
        String input = "programming";

        // STEP 1: Count the frequency of every character.
        Map<Character, Long> mp = input.chars()

                // chars() converts the string into an IntStream.
                // mapToObj() converts each integer character code into a Character.
                // Example: 112 -> 'p'
                .mapToObj(c -> (char) c)

                // groupingBy() groups identical characters together.
                // Function.identity() means use the character itself as the map key.
                // counting() counts how many times each character occurs.
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
                ));

        // Example frequency map:
        // p = 1, r = 2, o = 1, g = 2, a = 1, m = 2, i = 1, n = 1


        // STEP 2: Find the maximum frequency among all characters.
        // mp.values() returns all frequency values from the map.
        // Collections.max() finds the largest value.
        long max = Collections.max(mp.values());

        // For "programming", max = 2 because r, g, and m occur twice.


        // STEP 3: Find the FIRST character in the original string
        // whose frequency equals the maximum frequency.
        Character result = input.chars()

                // Convert each integer character code into a Character.
                .mapToObj(c -> (char) c)

                // Keep characters whose frequency in the map equals max.
                // mp.get(c) returns the frequency of character c.
                .filter(c -> mp.get(c) == max)

                // Return the first matching character in the original string.
                .findFirst()

                // If no character is found, return null.
                .orElse(null);

        // STEP 4: Print the most frequent character.
        System.out.println("Most frequent: " + result);
    }
}
