
1. Remove duplicate characters from a string

Input: "abcasdacb"
Output: [a, b, c, s, d]


import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {

        String str = "abcasdacb";

        List<Character> ans = str.chars()
            .mapToObj(c -> (char) c) // Convert int to Character
            .distinct()              // Keep first occurrence of each character
            .collect(Collectors.toList()); // Collect into a List

        System.out.println(ans);
    }
}

Remember: distinct() removes duplicates and preserves encounter order.

2. Find duplicate characters in a string

Input: "abcasdacb"
Output: [a, a, c, b]


import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {

        String str = "abcasdacb";
        Set<Character> seen = new HashSet<>();

        List<Character> ans = str.chars()
            .mapToObj(c -> (char) c) // Convert int to Character
            .filter(ch -> !seen.add(ch)) // Keep repeated occurrences
            .collect(Collectors.toList());

        System.out.println(ans);
    }
}

Remember: Set.add() returns false when an element already exists. The ! makes the filter keep those repeated occurrences.

3. Find characters that occur exactly once

Input: "abcasdacb"
Output: [s, d]


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {

        String str = "abcasdacb";

        // Count the occurrences of every character.
        Map<Character, Long> freq = str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(
                Function.identity(),
                LinkedHashMap::new,
                Collectors.counting()
            ));

        // Keep only characters whose frequency is exactly 1.
        List<Character> ans = freq.entrySet().stream()
            .filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        System.out.println(ans);
    }
}

Remember: count == 1 means a character occurs exactly once. LinkedHashMap preserves the order in which characters first appeared.

4. Count the frequency of each character

Input: "abcasdacb"
Output: {a=3, b=2, c=2, s=1, d=1}


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {

        String str = "abcasdacb";

        Map<Character, Long> freq = str.chars()
            .mapToObj(c -> (char) c) // Convert to Character
            .collect(Collectors.groupingBy(
                Function.identity(), // Character is the key
                LinkedHashMap::new,   // Preserve encounter order
                Collectors.counting() // Count occurrences
            ));

        System.out.println(freq);
    }
}

Remember: groupingBy(identity(), counting()) is the core frequency-counting pattern.

5. Count the frequency of each number in a list

Input: [1, 2, 3, 4, 2, 3]
Output: {1=1, 2=2, 3=2, 4=1}


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 2, 3);

        Map<Integer, Long> freq = list.stream()
            .collect(Collectors.groupingBy(
                Function.identity(), // Number is the key
                Collectors.counting() // Count occurrences
            ));

        System.out.println(freq);
    }
}

Remember: The same frequency pattern works for lists of integers, strings, or characters. Only the input stream changes.

6. Find even and odd numbers in a list

Input: [1, 2, 3, 4, 5, 6]

Output:

Even: [2, 4, 6]
Odd:  [1, 3, 5]

import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Group numbers into even (true) and odd (false).
        Map<Boolean, List<Integer>> result = list.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        // true represents even numbers; false represents odd numbers.
        System.out.println("Even: " + result.get(true));
        System.out.println("Odd: " + result.get(false));
    }
}

Remember: partitioningBy() divides elements into two groups based on a condition.

7. Find the maximum and minimum numbers

Input: [10, 5, 20, 3, 15]

Output:

Maximum: 20
Minimum: 3

import java.util.*;

class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 5, 20, 3, 15);

        // Find the largest number.
        Optional<Integer> max = list.stream()
            .max(Integer::compareTo);

        // Find the smallest number.
        Optional<Integer> min = list.stream()
            .min(Integer::compareTo);

        // Print results only if the list is not empty.
        max.ifPresent(n -> System.out.println("Maximum: " + n));
        min.ifPresent(n -> System.out.println("Minimum: " + n));
    }
}

Remember:

max() finds the largest element.

min() finds the smallest element.

Optional<Integer> safely represents a result that might not exist, such as when the list is empty.

8. Sort a list in ascending and descending order

Input: [5, 2, 8, 1, 3]

Output:

Ascending:  [1, 2, 3, 5, 8]
Descending: [8, 5, 3, 2, 1]

import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 2, 8, 1, 3);

        // Sort from smallest to largest.
        List<Integer> ascending = list.stream()
            .sorted()
            .collect(Collectors.toList());

        // Sort from largest to smallest.
        List<Integer> descending = list.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        System.out.println("Ascending: " + ascending);
        System.out.println("Descending: " + descending);
    }
}

Remember:

.sorted() → ascending order for integers.

.sorted(Comparator.reverseOrder()) → descending order.

collect(Collectors.toList()) → collects the result into a list.
