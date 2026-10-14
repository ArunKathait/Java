
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String args[]) {

        // Step 1: Create a list of integers.
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Step 2: Convert the list into a Stream.
        // partitioningBy() divides elements into two groups
        // based on whether the condition is true or false.
        Map<Boolean, List<Integer>> mp = list.stream()
            .collect(Collectors.partitioningBy(x -> x % 2 == 0));

        // Step 3: Get the group whose condition is true.
        // x % 2 == 0 means the number is even.
        // Therefore, mp.get(true) returns the even numbers.
        System.out.println("Even : " + mp.get(true));

        // Step 4: Get the group whose condition is false.
        // Numbers that are not even are odd.
        // Therefore, mp.get(false) returns the odd numbers.
        System.out.println("Odd : " + mp.get(false));
    }
}
