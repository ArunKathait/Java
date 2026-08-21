
import java.util.*;
import java.util.stream.Collectors;

class Main 
{
    public static void main(String args[])
    {
        List<String> names = Arrays.asList(
            "Java",
            "SpringBoot",
            "Microservices",
            "System Design",
            "Angular"
        );
        
        // Create a stream from the list and find the string
        // having the maximum length
        String longest = names.stream()
        
            // comparingInt(String::length) compares strings based on their length
            // max() returns the string with the greatest length
            .max(Comparator.comparingInt(String::length))
            
            // max() returns Optional<String>, so orElse(null)
            // returns the result if present, otherwise null
            .orElse(null);
        
        System.out.println(longest);
    }
}
