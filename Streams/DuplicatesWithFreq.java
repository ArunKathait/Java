

import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String args[]) {

        String str = "abcdefabcab";

        // Step 1: Count the frequency of every character.
        Map<Character, Long> mp = str.chars()
            // chars() returns an IntStream containing character values.
            // mapToObj() converts each int into a Character object.
            .mapToObj(c -> (char) c)

            // groupingBy() groups identical characters together.
            // c -> c means the character itself is the grouping key.
            // counting() counts how many times each character occurs.
            .collect(Collectors.groupingBy(
                c -> c,
                Collectors.counting()
            ));

        // Step 2: Find characters whose frequency is at least 2.
        List<Character> ans = str.chars()
            // Convert the string into a Stream<Character>.
            .mapToObj(c -> (char) c)

            // Keep only characters appearing at least twice.
            // mp.get(c) returns the frequency of character c.
            .filter(c -> mp.get(c) >= 2)

            // Keep each duplicate character only once.
            .distinct()

            // Collect the remaining characters into a List.
            .collect(Collectors.toList());

        // Step 3: Print each duplicate character and its frequency.
        ans.forEach(c -> {
            // c is the duplicate character.
            // mp.get(c) gives its total frequency.
            System.out.println(c + " : " + mp.get(c));
        });
    }
}
