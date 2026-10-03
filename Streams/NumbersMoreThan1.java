import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main
{
    public static void main(String args[])
    {
        // Input list containing some repeated numbers
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 2, 3, 4);

        // Step 1: Count how many times each number appears.
        // groupingBy(Function.identity(), ...) groups equal elements together
        //   - Function.identity() means "use the element itself as the key"
        // Collectors.counting() counts the size of each group (returns Long)
        // Resulting map: {1=1, 2=2, 3=2, 4=2}
        Map<Integer, Long> mp = list.stream().collect(Collectors.groupingBy(
            Function.identity(),
            Collectors.counting()));

        // Step 2: Find the duplicate elements.
        // list.stream()          -> stream over the original list [1,2,3,4,2,3,4]
        // filter(x -> mp.get(x) > 1)
        //                        -> keep only numbers whose count is greater than 1
        //                           (drops 1, keeps 2,3,4,2,3,4)
        // distinct()             -> remove repeated values, keeping first occurrence
        //                           (2,3,4,2,3,4 becomes 2,3,4)
        // collect(toList())      -> gather the result into a new List
        List<Integer> ans = list.stream()
                                .filter(x -> mp.get(x) > 1)
                                .distinct()
                                .collect(Collectors.toList());

        // Step 3: Print each duplicate element on its own line
        // Output:
        // 2
        // 3
        // 4
        ans.forEach(System.out::println);
    }
}
