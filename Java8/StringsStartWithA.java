
import java.util.*;           // Import all utility classes (List, Scanner, ArrayList, etc.)
import java.util.stream.*;    // Import Stream API classes for functional operations

class Main 
{
    public static void main(String args[])
    {
        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Prompt user to enter the number of strings they want to input
        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();   // Read integer input
        sc.nextLine();          // Consume the leftover newline after nextInt()

        // Create a list to store the strings entered by the user
        List<String> list = new ArrayList<>();

        // Loop n times to read n strings from the user
        for(int i = 0; i < n; i++)
        {
            // Prompt user to enter the ith string
            System.out.print("Enter string " + (i + 1) + ": ");
            list.add(sc.nextLine()); // Read the string and add it to the list
        }

        // Use Stream API to filter strings starting with 'a' (case-insensitive)
        // 1. list.stream() → Converts the list into a Stream of strings
        // 2. filter(s -> s.toLowerCase().startsWith("a")) → Keeps only strings where
        //    the lowercase version starts with 'a'
        // 3. collect(Collectors.toList()) → Collect the filtered stream back into a List
        List<String> ans = list.stream()
                               .filter(s -> s.toLowerCase().startsWith("a"))
                               .collect(Collectors.toList());

        // Print the filtered list of strings
        System.out.println("Strings starting with 'a':");
        ans.forEach(System.out::println); // For each string in the filtered list, print it
    }
}
