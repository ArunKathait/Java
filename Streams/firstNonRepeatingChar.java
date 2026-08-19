
import java.util.*;
import java.util.stream.Collectors;

class Main
{
    public static void main(String args[])
    {
        String str = "swiss";

        // Step 1: Count frequency of each character
        Map<Character, Long> mp = str.chars()
            // chars() gives integer values, mapToObj converts them to Character
            .mapToObj(c -> (char)c)
            .collect(
                // Group same characters and count their occurrences
                Collectors.groupingBy(
                    x -> x,
                    Collectors.counting()
                )
            );

        // Step 2: Traverse the ORIGINAL string and find the first character
        // whose frequency is exactly 1
        Character ans = str.chars()
            .mapToObj(c -> (char)c)
            .filter(x -> mp.get(x) == 1) // Keep only non-repeating characters
            .findFirst()                  // Take the first one in original order
            .orElse(null);                // If none exists, return null

        System.out.println(ans);
    }
}

/* NOTE : 

"swiss"
   ↓
groupingBy + counting()
   ↓
{s=3, w=1, i=1}
   ↓
Original String: s → w → i → s → s
   ↓
frequency == 1
   ↓
w → i
   ↓
findFirst()
   ↓
   w

*/
