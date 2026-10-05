import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {

        String str = "aeiouarun";

        // Convert the String into a stream of characters.
        // chars() gives the ASCII/Unicode value of each character.
        String ans = str.chars()

            // Convert each int value into a Character.
            // Example: 97 -> 'a'
            .mapToObj(c -> (char) c)

            // Keep only consonants.
            // "aeiou".indexOf(c) checks whether c is a vowel.
            //
            // If c is a vowel:
            // indexOf(c) gives 0, 1, 2, 3 or 4
            // So the condition becomes false -> character is removed.
            //
            // If c is NOT a vowel:
            // indexOf(c) gives -1
            // So the condition becomes true -> character is kept.
            .filter(c -> "aeiou".indexOf(c) == -1)

            // Convert Character into String.
            // Example: 'r' -> "r"
            //
            // String::valueOf is the short form of:
            // c -> String.valueOf(c)
            .map(String::valueOf)

            // Join all remaining characters into one String.
            // Example: "r", "n" -> "rn"
            .collect(Collectors.joining());

        // Print the final string containing only consonants.
        System.out.println(ans);
    }
}
