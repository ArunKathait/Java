
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
