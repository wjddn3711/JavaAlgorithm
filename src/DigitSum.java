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

class ResultDigitSum {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

//    public static int superDigit(String n, int k) {
//        // Write your code here
//        if(k != 0) n = String.join("", Collections.nCopies(k, n));
//        if(n.length() == 1) return Integer.parseInt(n);
//        int ret = 0;
//        for (int i = 0; i < n.length(); i++) {
//            ret+=Character.getNumericValue(n.charAt(i));
//        }
//        return superDigit(String.valueOf(ret), 0);
//    }

    public static int superDigit(String n, int k) {

        int temp = findSum(n) * k;

        if(temp>9){
            temp = findSum(String.valueOf(temp));
        }

        return temp;
    }

    static int findSum(String num){
        if(num.length() == 1){
            return Integer.parseInt(num);
        }

        int sum =0;
        for(int i=0; i<num.length(); i++){
            sum += Integer.parseInt(String.valueOf(num.charAt(i)));
        }

        return findSum(String.valueOf(sum));
    }

}

public class DigitSum {
    public static void main(String[] args) throws IOException {
        String n = "9875";
        int k = 4;

        System.out.println(ResultDigitSum.superDigit(n,k));
    }
}
