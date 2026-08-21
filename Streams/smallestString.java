import java.util.*;
import java.util.stream.Collectors;

class Main 
{
    public static void main(String args[])
    {
        // Create a List of Strings
        List<String> names = Arrays.asList(
            "Java",
            "SpringBoot",
            "Microservices",
            "System Design",
            "Angular"
        );
        
        // Create a Stream from the list
        String longest = names.stream()
        
            // comparingInt(String::length) compares strings based on their length
            // min() returns the String having the smallest length
            .min(Comparator.comparingInt(String::length))
            
            // min() returns Optional<String>
            // orElse(null) returns the String if present,
            // otherwise returns null
            .orElse(null);
        
        // Print the shortest String
        System.out.println(longest);
    }
}
