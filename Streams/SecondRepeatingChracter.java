

import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        String str = "aabcc";

        Map<Character, Long> mp = str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(
                c -> c,
                Collectors.counting()
            ));

        Character ans = str.chars()
            .mapToObj(c -> (char) c)
            .distinct()
            .filter(x -> mp.get(x) > 1)
            .skip(1)
            .findFirst()
            .orElse(null);

        System.out.println(ans);
    }
}
