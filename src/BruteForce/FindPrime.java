package BruteForce;

import java.util.HashSet;

public class FindPrime {
    static HashSet<Integer> set = new HashSet<>();
    static String numbers = "011";

    public static boolean isPrime(int num){
        // 소수는 자기 자신과 1 외에 나누어 떨어지면 안된다, 수학적으로는 루트 n 중에 나뉘어 떨어지는 경우가 있다면 소수가 아니다
        if(num == 1 || num == 0) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }

    public static void dfs(int depth, boolean[] visited, String now){
        if (depth == numbers.length()) return;
        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]){
                // 만약 방문 하지 않았다면
                visited[i] = true;
                set.add(Integer.parseInt(now+numbers.charAt(i))); // set 에 현재 방문하지 않은 숫자를 추가해준다
                dfs(depth+1, visited, now+numbers.charAt(i)); // 재귀적으로 반복
                visited[i] = false; // 모든 경우를 탐색하기 위해 백트래킹
            }
        }

    }

    public static void main(String[] args) {
        boolean[] visited = new boolean[numbers.length()];
        dfs(0, visited, "");
        int ret = 0;
        for (Integer integer : set) {
            if(isPrime(integer)) {
                ret++;
            }
        }
        System.out.println(ret);
    }
}
