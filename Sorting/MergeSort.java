
import java.util.*;

class Main 
{
    public static void merge(int[] arr, int low, int mid, int high)
    {
        // Temporary array to store merged sorted elements
        int[] temp = new int[high - low + 1];

        int i = low;       // Pointer for left half
        int j = mid + 1;   // Pointer for right half
        int k = 0;         // Pointer for temp array

        // Compare elements from both halves
        while (i <= mid && j <= high)
        {
            if (arr[i] <= arr[j])
            {
                temp[k++] = arr[i];
                i++;
            }
            else
            {
                temp[k++] = arr[j];
                j++;
            }
        }

        // Copy remaining elements from left half
        while (i <= mid)
        {
            temp[k++] = arr[i];
            i++;
        }

        // Copy remaining elements from right half
        while (j <= high)
        {
            temp[k++] = arr[j];
            j++;
        }

        // Copy sorted elements back to original array
        for (int x = 0; x < temp.length; x++)
        {
            arr[low + x] = temp[x];
        }
    }

    public static void mergeSort(int[] arr, int low, int high)
    {
        // Continue dividing until only one element remains
        if (low < high)
        {
            // Find middle
            int mid = low + (high - low) / 2;

            // Sort left half
            mergeSort(arr, low, mid);

            // Sort right half
            mergeSort(arr, mid + 1, high);

            // Merge both sorted halves
            merge(arr, low, mid, high);
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println("Enter the numbers:");

        int[] arr = new int[n];

        // Take input
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Apply Merge Sort
        mergeSort(arr, 0, n - 1);

        // Print sorted array
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
