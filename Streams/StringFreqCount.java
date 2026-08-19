
import java.util.*; 
import java.util.stream.Collectors; 
 
class Main  
{ 
    public static void main(String args[]) 
    { 
        // Input String
        String str = "hello"; 
 
        /*
         * str.chars()
         * ----------------
         * Converts the String into an IntStream.
         *
         * "hello"
         *   ↓
         * 104, 101, 108, 108, 111
         *
         * These are the ASCII/Unicode values of:
         * h, e, l, l, o
         */
        Map<Character, Long> mp = str.chars() 
 
            /*
             * mapToObj()
             * ----------------
             * chars() gives integer values.
             * We convert each integer back to Character.
             *
             * 104 → 'h'
             * 101 → 'e'
             * 108 → 'l'
             * 108 → 'l'
             * 111 → 'o'
             */
            .mapToObj(c -> (char)c) 
 
            /*
             * collect()
             * ----------------
             * Collects the stream result into a Map.
             */
            .collect( 
 
                /*
                 * groupingBy(x -> x)
                 * ----------------
                 * Groups the same characters together.
                 *
                 * h → [h]
                 * e → [e]
                 * l → [l, l]
                 * o → [o]
                 */
                Collectors.groupingBy( 
 
                    // x itself becomes the key of the Map
                    x -> x, 
 
                    /*
                     * counting()
                     * ----------------
                     * Counts how many times each character occurs.
                     *
                     * h → 1
                     * e → 1
                     * l → 2
                     * o → 1
                     */
                    Collectors.counting() 
                ) 
            ); 
 
        // Print the frequency Map
        System.out.println(mp); 
    } 
}
