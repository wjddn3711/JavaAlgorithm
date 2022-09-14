import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        // Write your code here
        // declare bracket seq of start and end
        List<Character> startSeq = Arrays.asList('{','[','(');
        List<Character> endSeq = Arrays.asList('}',']',')');

        // declare Stack to save current determine target
        Stack<Character> stack = new Stack<>();


        // step 1 : loop until s.length
        for (int i = 0; i < s.length(); i++) {
            // if stack is empty, add to stack
            if (stack.isEmpty()){
                if(startSeq.contains(s.charAt(i))){
                    stack.push(s.charAt(i));
                }
                // if stack is empty but its not openning bracket, then return no
                else return "NO";
            }
            // if stack is not empty
            else{
                // current target is peek of stack
                char current = stack.peek();
                // step 2 : find rather current matches with closing bracket
                // if its openning bracket, push to stack
                if(startSeq.contains(s.charAt(i))){
                    stack.push(s.charAt(i));
                }
                else{
                    // if its closing bracket, find if it matches with current
                    if(startSeq.indexOf(current) == endSeq.indexOf(s.charAt(i))){
                        // if matches, pop from stack
                        stack.pop();
                    }
                    else return "NO";
                }
            }
        }
        // if last element is openning bracket, stack is not empty
        if(!stack.isEmpty()) return "NO";
        return "YES";
    }

    public static void main(String[] args) {
        // declare bracket seq of start and end
        System.out.println(isBalanced("{[()]}"));
    }
}
