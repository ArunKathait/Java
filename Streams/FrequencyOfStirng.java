import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {

        String input = "stringdata";

        // Step 1: Convert the string into a stream of integer character values.
        // Example: 's' -> 115, 't' -> 116, 'r' -> 114, etc.
        Map<Character, Long> frequencies = input.chars()

            // Step 2: Convert each integer character value into a Character object.
            // This is required because we want Character keys in our Map.
            .mapToObj(c -> (char) c)

            // Step 3: Group identical characters together and count their occurrences.
            .collect(Collectors.groupingBy(

                // Use each character itself as the key.
                // Function.identity() returns the input unchanged.
                Function.identity(),

                // Count how many times each character appears.
                // The count is stored as a Long value.
                Collectors.counting()
            ));

        // Step 4: Print the character-frequency map.
        System.out.println(frequencies);
    }
}
