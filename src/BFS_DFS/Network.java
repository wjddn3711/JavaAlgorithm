package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    static boolean[] visited; // 방문 여부를 저장
    static int[][] graph; // 컴퓨터 그래프 저장
    static int n; // 컴퓨터의 개수 저장

    public static void bfs(int computer){
        // 자기자신은 항상 연결 되어 있으니 고려하지 않음
        Queue<Integer> queue = new LinkedList<>(); // 큐 생성
        queue.add(computer); // 시작 위치 큐에 담기
        visited[computer] = true; // 시작 위치 방문처리
        while(!queue.isEmpty()){
            // 큐가 비지 않을때 까지 계속
            int node = queue.poll(); // 큐에서 하나의 노드를 빼옴
            for (int i = 0; i < n; i++) {
                if(i!=node && !visited[i] && graph[node][i]==1){
                    // 만약 노드가 자기자신이 아니고, 방문한 적이 없으며 연결되어있다면 방문처리 후 큐에 담아준다
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        // 샘플 그래프
        graph = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        // 전역 변수 값 지정
        n = graph.length;
        visited = new boolean[n];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            // 만약 해당 컴퓨터가 방문한적 없는 컴퓨터라면 bfs를 수행하고 카운트 1증가
            if(!visited[i]){
                cnt++;
                bfs(i);
            }
        }

        System.out.println(cnt);
    }
}
