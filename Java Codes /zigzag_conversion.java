import java.util.*;

public class ZigzagConversion {

    public static String convert(String s, int numRows) {

        // Edge case:
        // If only 1 row, zigzag is same as original string
        if (numRows == 1) {
            return s;
        }

        // Length of input string
        int n = s.length();

        // Flag to control direction (down = true, up = false)
        boolean flag = false;

        // List to store each row (like vector<string> in C++)
        // Each row will be a StringBuilder (for fast appending)
        List<StringBuilder> rows = new ArrayList<>();

        // Initialize all rows with empty StringBuilder
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        // 'i' represents current row index
        int i = 0;

        // Traverse each character of the string
        for (int j = 0; j < n; j++) {

            // If we are at first row OR last row,
            // change the direction (down ↔ up)
            if (i == 0 || i == numRows - 1) {
                flag = !flag;
            }

            // Add current character to the current row
            rows.get(i).append(s.charAt(j));

            // Move to next row depending on direction
            if (flag) {
                i++;   // move down
            } else {
                i--;   // move up
            }
        }

        // Combine all rows into final answer
        StringBuilder ans = new StringBuilder();

        // Append each row into final result
        for (StringBuilder row : rows) {
            ans.append(row);
        }

        // Convert StringBuilder to String and return
        return ans.toString();
    }

    // Main method (for user input)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input string
        System.out.print("Enter string: ");
        String s = sc.nextLine();

        // Take number of rows
        System.out.print("Enter number of rows: ");
        int numRows = sc.nextInt();

        // Call convert function
        String result = convert(s, numRows);

        // Print final zigzag converted string
        System.out.println("Zigzag Conversion: " + result);

        // Close scanner
        sc.close();
    }
}
