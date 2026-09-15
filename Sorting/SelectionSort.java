
import java.util.*;

class Main {

    public static void selectionSort(int[] arr, int n) {

        // Traverse each position
        for (int i = 0; i < n - 1; i++) {

            // Assume current element is minimum
            int mini = i;

            // Find minimum element in remaining array
            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }

            // Swap minimum element with arr[i]
            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take size of array
        System.out.print("Enter size: ");
        int n = sc.nextInt();

        // Create array
        int[] arr = new int[n];

        // Take array elements
        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call Selection Sort
        selectionSort(arr, n);

        // Print sorted array
        System.out.println("Sorted array:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
