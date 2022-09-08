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

class ResultLonelyInteger {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        // first get distinct List value
        int answer = 0;
        List<Integer> distinctList = a.stream().distinct().collect(Collectors.toList());
        for (Integer integer : distinctList) {
            // integer is distinct unique number, count frequency of these number in original list
            int freq = Collections.frequency(a, integer);
            if(freq == 1) answer = integer.intValue();
            break;
        }
        return answer;
    }

}

public class LonelyInteger {
    public static void main(String[] args) throws IOException {

        List<Integer> a = Arrays.asList(4,9,95,93,57,4,57,93,9);

        int result = ResultLonelyInteger.lonelyinteger(a);

        System.out.println(result);
    }
}
