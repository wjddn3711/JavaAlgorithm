import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Stack<String> prev =  new Stack<>();
        // get the count of operations
        int q = sc.nextInt();
        int op; // operation integer
        String now = "";
        for (int i = 0; i < q; i++) {
            // first get operation int
            op = sc.nextInt();
            // consider operation 1
            if (op==1){
                String subString = sc.next(); // get target to append
                prev.push(now); // save original value
                now += subString; // append to the original string
            }
            else if( op == 2 ){
                // delete last n value of original
                int n = sc.nextInt();
                prev.push(now); // save original value
                // excluding nth value using subString
                now = now.substring(0,now.length()-n);
            }
            else if( op == 3 ){
                // print nth value of original
                int n = sc.nextInt();
                System.out.println(now.charAt(n-1));
            }
            else {
                // if its 4, undo the last operant
                now = prev.pop();
            }
        }
    }
}
