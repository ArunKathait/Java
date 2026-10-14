
import java.util.*;

class Main {
    public static void main(String[] args) {

        // The number whose digits we want to add.
        int n = 15;

        // Step 1: Convert the integer into a String.
        // 15 becomes "15".
        // Step 2: chars() converts the String into an IntStream
        // containing character codes for '1' and '5'.
        // Step 3: Character.getNumericValue converts each
        // character code into its actual digit: 1 and 5.
        // Step 4: sum() adds all the digits: 1 + 5 = 6.
        int ans = String.valueOf(n)
                .chars()
                .map(Character::getNumericValue)
                .sum();

        // Print the sum of the digits.
        System.out.println(ans);  // Output: 6
    }
}
