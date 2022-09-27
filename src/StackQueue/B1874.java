package StackQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.
 */
public class B1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>(); // int형 스택 선언
        List<String> answers = new ArrayList<>(); // 결과값을 담을 answers
        int len = sc.nextInt(); // 스택의 길이
        int cnt = 1;

        for (int i = 0; i < len; i++) {
            int now = sc.nextInt();
            // now 까지 삽입 진행
            while(cnt <= now){
                // 초기 1~now 까지 삽입
                stack.push(cnt);
                answers.add("+");
                cnt++;
            }

            if(stack.peek() == now){
                answers.add("-");
                stack.pop();
            }
            else{
                // 만약 peek 가 현재 값이 아닐경우 스택이 성립 할 수 없음
                System.out.println("NO");
                return;
            }
        }

        for (String answer : answers) {
            System.out.println(answer);
        }
    }
}
