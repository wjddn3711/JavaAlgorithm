import java.io.*;
import java.util.Scanner;
import java.util.stream.IntStream;

class ResultPalindromeIndex {

    public static int palindromeIndex(String s) {
        // // Write your code here
        int len = s.length();
        int start = 0;
        int end = len - 1;

        while (start < end) {
            // if its not palindrome exit
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start++;
            end--;
        }
        // if its palindrome start == end
        if (start >= end) return -1;

        // if not palindrome, starting from breakpoint find where to delete
        int i = start;
        int j = end;
        // consider excluding start , if not palindrome, should exclude
        start++;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return j;
            }
            start++;
            end--;
        }
        return i;
    }

}

public class PalindromeIndex {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int q = 3;
        for (int i = 0; i < q; i++) {
            String s = sc.next();

            int result = ResultPalindromeIndex.palindromeIndex(s);
            System.out.println(result);
        }

    }
}