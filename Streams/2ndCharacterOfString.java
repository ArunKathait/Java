import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {

        // Create a list of strings
        List<String> list = Arrays.asList(
            "Arun",
            "A",
            "Rahul",
            "S",
            "Simran"
        );

        // Get the second character from every string
        List<Character> ans = list.stream()

            // Keep only strings having at least 2 characters
            .filter(str -> str.length() >= 2)

            // Get the character at index 1
            // Index starts from 0, so index 1 = second character
            .map(str -> str.charAt(1))

            // Convert the stream into a List<Character>
            .collect(Collectors.toList());

        // Print the result
        System.out.println(ans);
    }
}
