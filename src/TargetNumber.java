import java.util.ArrayList;
import java.util.List;

public class TargetNumber {
    static int res = 0;
    static boolean[] visited;
    static class Solution {
        void dfs(int idx, int[] numbers, int sum, int target){
            int n = numbers.length;
            System.out.printf("idx : %d, sum : %d\n", idx, sum);
            if (idx == n){
                // 만약 최종 인덱스에 도달하였다면
                if (sum == target) res++; // 타겟넘버와 같은 값이라면 res ++;
                return;
            }
            dfs(idx+1, numbers, sum+numbers[idx], target);
            dfs(idx+1, numbers, sum-numbers[idx], target);
        }

        public int solution(int[] numbers, int target) {
            int answer = 0;

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        Solution solution = new Solution();
        visited = new boolean[5];
        solution.dfs(0,numbers,0,3);
        System.out.println(res);

    }
}
