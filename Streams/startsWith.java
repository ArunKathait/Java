
import java.util.*;

class Main {
    public static void main(String args[]) {

        // Create a List of Strings
        List<String> list = Arrays.asList(
                "know",
                "ask",
                "down",
                "amount",
                "loyal",
                "any"
        );

        // Character that we want to search for
        char ch = 'a';

        // Convert the List into a Stream
        list.stream()

                // filter() keeps only those strings
                // whose first character is 'a'
                //
                // String.valueOf(ch)
                // converts char 'a' into String "a"
                //
                // Example:
                // "ask".startsWith("a")    -> true
                // "know".startsWith("a")   -> false
                // "amount".startsWith("a") -> true
                .filter(str -> str.startsWith(String.valueOf(ch)))

                // Print every string that passed the filter
                //
                // System.out::println is a method reference
                // equivalent to:
                //
                // .forEach(str -> System.out.println(str))
                .forEach(System.out::println);
    }
}

***********************************************USER INPUT*******************************************************

import java.util.*;
import java.util.stream.Collectors;

class Main 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        List<String> names = Arrays.asList(
            "apple",
            "amla",
            "orange",
            "mango"
        );

        // Take character input from user
        System.out.print("Enter starting character: ");
        char ch = sc.next().charAt(0);

        // Find words starting with the given character
        List<String> ans = names.stream()
            .filter(name -> name.startsWith(String.valueOf(ch)))
            .collect(Collectors.toList());

        // Print result
        ans.forEach(System.out::println);

        sc.close();
    }
}
