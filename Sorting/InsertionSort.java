
import java.util.*;

class Main {

    public static void insertionSort(int[] arr, int n) {

        // Start from index 0 and go until the last element
        for (int i = 0; i < n; i++) {

            // j represents the current element
            // that we want to place at its correct position
            int j = i;

            // Keep comparing with the previous element
            // If previous element is greater, swap them
            while (j > 0 && arr[j - 1] > arr[j]) {

                // Store current element temporarily
                int temp = arr[j];

                // Move previous element to the right
                arr[j] = arr[j - 1];

                // Put current element on the left
                arr[j - 1] = temp;

                // Move j one position to the left
                j--;
            }
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // Ask the user to enter the numbers
        System.out.println("Enter the numbers:");

        // Read size of array
        int n = sc.nextInt();

        // Create an array of size n
        int[] arr = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call insertion sort
        insertionSort(arr, n);

        // Print the sorted array
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
