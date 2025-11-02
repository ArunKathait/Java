
import java.util.*;  
// Importing the java.util package to use Scanner class for input

class Main               // TC ---> O(N)                                        SC ---> O(N)
{
    // Function to reverse the words in a given sentence
    public static String reverseWords(String str)
    {
        // Step 1: Remove leading/trailing spaces using trim()
        // and split the string into words using one or more spaces ("\\s+")
        String[] words = str.trim().split("\\s+");
        
        // Step 2: Create a StringBuilder for efficient string concatenation
        StringBuilder sb = new StringBuilder();
        
        // Step 3: Traverse the 'words' array from the end to the beginning
        for (int i = words.length - 1; i >= 0; i--)
        {
            // Append the current word to StringBuilder
            sb.append(words[i]);
            
            // Add a space between words, except after the last word
            if (i > 0) sb.append(" ");
        }
        
        // Step 4: Convert StringBuilder back to a string and return
        return sb.toString();
    }
    
    public static void main(String args[])
    {
        // Step 1: Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        
        // Step 2: Read the entire line as input
        String str = sc.nextLine();
        
        // Step 3: Call the reverseWords function
        String res = reverseWords(str);
        
        // Step 4: Print the reversed sentence
        System.out.println("After Reverse: " + res);
    }
}

/*          
NOTE : 
         
🔍 Example Execution

Input:

  hello   world  from   Java  


Steps performed:

(1) trim() → removes leading/trailing spaces → "hello world from Java"

(2) split("\\s+") → splits by multiple spaces → ["hello", "world", "from", "Java"]
                  → splits the string by one or more spaces (tabs, newlines, etc.).

(3) Loop reverses it → "Java from world hello"

Output:

After Reverse: Java from world hello


✅ Key Concepts Used:

(1) trim() → removes extra spaces at beginning and end

(2) split("\\s+") → splits using any number of spaces

(3) StringBuilder → more efficient than normal string concatenation in loops

(4) Reversing loop → builds the reversed sentence
