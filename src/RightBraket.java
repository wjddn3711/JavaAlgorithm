import java.util.Stack;

public class RightBraket {

    static char[] bracket = {'(',')'};

    public static void main(String[] args) {
        String s = ")()(";

        Stack<Character> stack = new Stack<>();
        boolean answer = true;
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                // 현재 스택이 비어있는 경우
                if(s.charAt(i)=='(') stack.push('(');
                else {
                    answer = false;
                    break;
                }
            }
            else{
                // 현재 스택이 비어있지 않은 경우
                if(s.charAt(i)=='(') stack.push('(');
                else{
                    stack.pop(); // 스택의 마지막을 꺼낸다 () 가 만났기 때문
                }
            }
        }

        if(stack.size()>0){
            // 아직 사라지지 않은 브라켓이 존재한다면 false로
            answer = false;
        }
        System.out.println(answer);
    }
}
