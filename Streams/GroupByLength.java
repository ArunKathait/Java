
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String args[]) {

        // Create a list of names
        List<String> list = Arrays.asList(
            "Arun", "Shikha", "Shreya", "Om", "Roop"
        );

        // Group names based on their length
        Map<Integer, List<String>> mp = list.stream()

            // groupingBy() groups elements having the same key
            // x.length() calculates the length of each name
            // Key   = Name length
            // Value = List of names having that length
            .collect(Collectors.groupingBy(x -> x.length()));

        // Iterate through the Map
        // length represents the Map key
        // names represents the List of names (Map value)
        mp.forEach((length, names) -> {

            // Print the length and corresponding names
            System.out.println("Length : " + length + " Names : " + names);
        });
    }
}
