
import java.util.*;
import java.util.stream.Collectors;

class Main 
{
    public static void main(String args[])
    {
        // Create a list containing names and empty strings
        List<String> list = Arrays.asList("Arun", "", "Shreya", "Adarsh", "");

        // Convert the list into a Stream
        // filter() removes elements that are blank
        // x.isBlank() returns true if the string is empty or contains only whitespace
        // ! means NOT, so only non-blank strings are retained
        // collect() converts the filtered Stream back into a List
        List<String> ans = list.stream()
                                .filter(x -> !x.isBlank())
                                .collect(Collectors.toList());

        // Print each element of the resulting list
        ans.forEach(System.out::println);
    }
}
