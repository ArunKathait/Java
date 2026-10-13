
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String args[]) {

        String str = "abcdefabc";

        // HashSet stores characters we have already encountered.
        // It does not allow duplicate elements.
        HashSet<Character> st = new HashSet<>();

        // Step 1: Convert the String into a stream of characters.
        // Step 2: Convert each int character value into Character.
        // Step 3: Keep only characters that have already appeared.
        // Step 4: Collect those duplicate occurrences into a List.
        List<Character> ans = str.chars()
                .mapToObj(c -> (char) c)
                .filter(x -> !st.add(x))
                .collect(Collectors.toList());

        // Print the duplicate occurrences.
        System.out.println(ans);
    }
}
