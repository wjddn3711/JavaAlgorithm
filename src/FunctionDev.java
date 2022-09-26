import java.util.Arrays;
import java.util.Stack;

public class FunctionDev {
    static class Task{
        int spends; // 몇일 걸리는지
        int count; // 개수

        public Task(int spends, int count){
            this.spends = spends;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "spends=" + spends +
                    ", count=" + count +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        Stack<Task> stack = new Stack<>();

        // 루프를 돌면서 각각 몇일 걸리는지 파악한다
        for(int i=0; i<progresses.length; i++){
            // 현재 업무가 언제 끝나는지 파악
            int left = 100-progresses[i]; // 남은 작업 진척도
            // 완전히 나뉘어 떨어지지 않는다면 +1 일 더 걸리는거
            int spend = left%speeds[i]==0? left/speeds[i] : left/speeds[i] + 1;
            if(stack.isEmpty()){
                stack.push(new Task(spend, 1)); // 만약 스택이 비어있다면 새롭게 추가해준다, 카운트는 1로
            }
            else{
                if(stack.peek().spends >= spend){
                    // 만약 이전 작업보다 소요시간이 적다면 이전 작업 시간만큼 걸리게된다
                    Task current = stack.pop();
                    current.count += 1;
                    stack.push(current); // 카운트를 1 증가시키고 스택에 다시 삽입
                }
                else{
                    // 만약 이전 작업보다 소요시간이 많다면
                    stack.push(new Task(spend, 1)); // 새롭게 스택에 추가
                }
            }
        }

//        stack.stream().forEach(s-> System.out.println(s));

        int[] answer = stack.stream().mapToInt(task -> task.count).toArray();
        Arrays.stream(answer).forEach(v -> System.out.println(v));
    }
}
