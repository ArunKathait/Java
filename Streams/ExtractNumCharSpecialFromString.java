
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Input string containing letters, digits, spaces, and special characters.
        String input = "Hello123, World@45! #C++";

        // STEP 1: Extract only letters (A-Z and a-z).
        String letters = input.chars()

                // chars() converts the string into an IntStream.
                // Each element is an integer representing a character's UTF-16 code unit.

                .filter(Character::isLetter)
                // Keep only letters.
                // Equivalent to: .filter(c -> Character.isLetter(c))

                .mapToObj(c -> String.valueOf((char) c))
                // Convert each integer character code into a String.
                // Example: 72 -> 'H' -> "H"

                .collect(Collectors.joining());
                // Join all the remaining strings into one string.
                // Example: "H", "e", "l", "l", "o" -> "Hello"


        // STEP 2: Extract only digits (0-9).
        String digits = input.chars()

                // Keep only numeric digit characters.
                .filter(Character::isDigit)

                // Convert each integer character code into a String.
                .mapToObj(c -> String.valueOf((char) c))

                // Join all digits into one string.
                // Example: "1", "2", "3" -> "123"
                .collect(Collectors.joining());


        // STEP 3: Extract special characters, excluding whitespace.
        String specials = input.chars()

                // Keep characters that are NOT letters or digits.
                // This initially includes punctuation and whitespace.
                .filter(c -> !Character.isLetterOrDigit(c)

                        // Exclude spaces, tabs, and other whitespace characters.
                        && !Character.isWhitespace(c))

                // Convert each remaining character code into a String.
                .mapToObj(c -> String.valueOf((char) c))

                // Join all special characters into one string.
                .collect(Collectors.joining());


        // STEP 4: Print the original input and the extracted results.
        System.out.println("Input    : " + input);
        System.out.println("Letters  : " + letters);
        System.out.println("Numbers  : " + digits);
        System.out.println("Specials : " + specials);
    }
}

**************************************************SMALL CHANGE*********************************************************

import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String args[]) {

        // Input string containing letters, digits, spaces, and special characters
        String str = "abcd1234 & * % !";

        // Extract all digits from the string
        String digits = str.chars() // Convert string into an IntStream of character values
            .mapToObj(c -> (char) c) // Convert each integer value into a Character object
            .filter(Character::isDigit) // Keep only digits (0-9)
            .map(String::valueOf) // Convert each Character into a String
            .collect(Collectors.joining()); // Join all digits into one String

        // Extract all letters from the string
        String letters = str.chars()
            .mapToObj(c -> (char) c) // Convert integer values into Character objects
            .filter(Character::isLetter) // Keep only alphabetic characters
            .map(String::valueOf) // Convert each Character into a String
            .collect(Collectors.joining()); // Join all letters into one String

        // Extract special characters, excluding whitespace
        String special = str.chars()
            .mapToObj(c -> (char) c) // Convert integer values into Character objects
            .filter(c -> !Character.isLetter(c) // Exclude letters
                      && !Character.isDigit(c) // Exclude digits
                      && !Character.isWhitespace(c)) // Exclude spaces and whitespace
            .map(String::valueOf) // Convert each Character into a String
            .collect(Collectors.joining()); // Join special characters into one String

        // Print the results
        System.out.println("Digits : " + digits);
        System.out.println("Letters : " + letters);
        System.out.println("Special : " + special);
    }
}
