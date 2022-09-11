
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

class ResultNewYearChaos {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        // make q array
        Integer[] qs = q.stream().toArray(Integer[]::new);
        // set minium bribe as 0
        int minBribes = 0;
        for (int i = 0; i < qs.length; i++) {
            // if needs more than 2 bribes
            if (qs[i] - 2 > i + 1) {
                System.out.println("Too chaotic");
                return;
            }
            // starting from end, if can change, swap
            for (int j = i - 1; j >= qs[i] - 2 && j >= 0; j--) {
                if (qs[j] > qs[i]) minBribes++;
            }
        }
        System.out.println(minBribes);
    }

}

public class NewYearChaos {
    public static void main(String[] args) throws IOException {
        List<Integer> q = Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4);
        ResultNewYearChaos.minimumBribes(q);
    }
}

