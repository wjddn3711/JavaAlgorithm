package BruteForce;

public class Fatigue {
    static int maxVal = 0; // 갈 수 있는 최대 던전 개수
    static int[][] dungeons;

    public static void dfs(boolean[] visited, int depth, int hp){
        // 현재 방문된 던전과 방문한 던전 개수, 현재 피로도를 매개변수로 받아옴
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && hp>=dungeons[i][0]){
                // 방문한적이 없으며 현재 남은 피로도가 던전 최소요구 피로도 보다 많을때 해당 던전을 탐험한다
                visited[i] = true;
                dfs(visited, depth+1, hp-dungeons[i][1]);
                visited[i] = false; // 백트래킹하여 이외의 경우도 고려
            }
        }

        maxVal = Math.max(depth, maxVal);
    }

    public static void main(String[] args) {
        dungeons = new int[][]{{80,20},{50,40},{30,10}};
        boolean[] visited = new boolean[dungeons.length];
        int k = 80;
        dfs(visited, 0, k);
        System.out.println(maxVal);
    }
}
