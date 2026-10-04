
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {

        String str = "aabcc";

        // Step 1: Count the frequency of each character.
        // chars() converts the String into an IntStream of character values.
        // mapToObj(c -> (char) c) converts each int into a Character.
        // groupingBy() groups identical characters together.
        // counting() counts how many times each character occurs.
        Map<Character, Long> mp = str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(
                c -> c,
                Collectors.counting()
            ));

        // mp = {a=2, b=1, c=2}

        // Step 2: Find the first character whose frequency is greater than 1.
        Character ans = str.chars()

            // Convert each character value into a Character object.
            .mapToObj(c -> (char) c)

            // Keep only the first occurrence of each character,
            // preserving the original encounter order: a, b, c.
            .distinct()

            // Keep characters whose frequency is greater than 1.
            .filter(x -> mp.get(x) > 1)

            // Return the first character that passes the filter.
            .findFirst()

            // If no repeating character exists, return null.
            .orElse(null);

        // Step 3: Print the first repeating character.
        System.out.println(ans);
    }
}
