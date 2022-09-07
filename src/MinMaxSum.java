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

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */



    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        // slicing list, in ordered list min value eq [:-1] max value eq [1:]
        long min = arr.subList(0, 4).stream().mapToLong(n -> n).sum();
        long max = arr.subList(1, 5).stream().mapToLong(n -> n).sum();

        // should notice hidden cases bigger than int32
        System.out.printf(min+" "+max);
    }
}

public class MinMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
