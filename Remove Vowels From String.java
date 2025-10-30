import java.util.*;  
// Importing java.util package to use Scanner for taking user input

class Main {

    // Method to remove vowels from a given string
    public static String check(String str) {
        // Using StringBuilder because it is more efficient than string concatenation
        StringBuilder sb = new StringBuilder();

        // Loop through each character of the input string
        for (int i = 0; i < str.length(); i++) {
            // Get the current character at index i
            char ch = str.charAt(i);
            
            // Check if the character is NOT a vowel (both lowercase and uppercase)
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' &&
                ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U') {
                // If not a vowel, append the character to StringBuilder
                sb.append(ch);
            }
        }

        // Convert StringBuilder back to a String and return it
        return sb.toString();
    }

    // Main method — program starts executing from here
    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.println("Enter a string:");

        // Read the full line input from user
        String str = sc.nextLine();

        // Call the check() method to remove vowels
        String res = check(str);

        // Print the result after removing vowels
        System.out.println("String after removing vowels: " + res);
    }
}
