
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

class ResultCaesarCipher {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = lower.toUpperCase();
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i))) answer += upper.indexOf(s.charAt(i)) + k >= 26 ?
                    upper.charAt((upper.indexOf(s.charAt(i)) + k) % 26) : upper.charAt(upper.indexOf(s.charAt(i)) + k);
            else if(Character.isLowerCase(s.charAt(i))) answer += lower.indexOf(s.charAt(i)) + k >= 26 ?
                    lower.charAt((lower.indexOf(s.charAt(i)) + k) % 26) : lower.charAt(lower.indexOf(s.charAt(i)) + k);
            else answer += s.charAt(i);
        }
        return answer;
    }

}

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        String s = bufferedReader.readLine();
//
//        int k = Integer.parseInt(bufferedReader.readLine().trim());

        int n = 14;
        int k = 4;
        String s = "Hello_World!";

        String result = ResultCaesarCipher.caesarCipher(s, k);
        System.out.println(result);
    }
}
