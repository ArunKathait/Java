
import java.util.*;

class Main 
{
    // Places the pivot at its correct position
    // and returns the pivot index
    public static int find(int[] arr, int low, int high)
    {
        // Choose the first element as pivot
        int pivot = arr[low];

        // i moves from left to right
        int i = low;

        // j moves from right to left
        int j = high;

        while(i < j)
        {
            // Find an element greater than pivot
            // which is on the wrong side
            while(i <= high && arr[i] <= pivot)
            {
                i++;
            }

            // Find an element smaller than or equal to pivot
            // which is on the wrong side
            while(j >= low && arr[j] > pivot)
            {
                j--;
            }

            // If pointers have not crossed,
            // swap the wrong elements
            if(i < j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Put pivot into its correct position
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        // Return pivot's final position
        return j;
    }

    public static void quickSort(int[] arr, int low, int high)
    {
        // At least two elements are required
        if(low < high)
        {
            // Partition the array
            int partI = find(arr, low, high);

            // Sort left side of pivot
            quickSort(arr, low, partI - 1);

            // Sort right side of pivot
            quickSort(arr, partI + 1, high);
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // Read size
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Read elements
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Quick Sort
        quickSort(arr, 0, n - 1);

        // Print sorted array
        for(int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
