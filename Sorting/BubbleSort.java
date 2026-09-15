
import java.util.*;

class Main {

    public static void bubbleSort(int[] arr, int n) {

        // Move from the last position towards the first
        for (int i = n - 1; i >= 0; i--) {

            // Compare adjacent elements
            for (int j = 0; j < i; j++) {

                // If left element is greater,
                // swap the two elements
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements:");

        // Take array input
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call Bubble Sort
        bubbleSort(arr, n);

        // Print sorted array
        System.out.println("Sorted array:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
