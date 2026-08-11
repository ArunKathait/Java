
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String args[]) {

        // Create a List of names
        List<String> names = Arrays.asList(
            "arun",
            "sarthak",
            "prince",
            "shivam",
            "shubham",
            "rohit"
        );

        /*
         * names.stream()
         *
         * Converts the List into a Stream.
         *
         * Stream allows us to process each element
         * one by one using operations like:
         * filter(), map(), sorted(), etc.
         */
        List<String> ans = names.stream()

                /*
                 * map() is used when we want to TRANSFORM
                 * or CHANGE every element.
                 *
                 * Here:
                 *
                 * "arun"    -> "ARUN"
                 * "sarthak" -> "SARTHAK"
                 * "prince"  -> "PRINCE"
                 *
                 * String::toUpperCase is a method reference.
                 *
                 * It is equivalent to:
                 *
                 * name -> name.toUpperCase()
                 */
                .map(String::toUpperCase)

                /*
                 * collect() is used to collect the Stream
                 * result into a collection.
                 *
                 * Collectors.toList() means:
                 * "Put all the Stream elements into a List."
                 */
                .collect(Collectors.toList());

        /*
         * forEach() goes through every element of ans
         * and prints it.
         *
         * System.out::println is a method reference.
         *
         * It is equivalent to:
         *
         * ans.forEach(name -> System.out.println(name));
         */
        ans.forEach(System.out::println);
    }
}
