import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11724 {
    static boolean[] visited;
    static boolean[][] map;

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ve = br.readLine().split(" ");
        n = Integer.parseInt(ve[0]); // 정점의 개수
        int m = Integer.parseInt(ve[1]); // 간선의 개수

        visited = new boolean[n+1]; // 각 노드의 방문 여부를 저장할 visited. 1부터이기때문에 0번째 인덱스는 비워준다
        map = new boolean[n+1][n+1]; // 각 노드와 노드간의 이어져 있는지 여부를 저장할 배열
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 이어져 있는 노드들을 큐에 담는다
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            map[node1][node2] = true;
            map[node2][node1] = true;
        }
        br.close(); // 버퍼 닫기

        int ret = 0;
        for (int i = 1; i < n+1; i++) {
            // 방문하지 않은 경우 bfs 수행
            if (!visited[i]){
                bfs(i);
                ret++;
            }
        }
        System.out.println(ret);
    }

    public static void bfs(int start){
        // 큐에서 뽑아와 이어져있는 노드들을 탐색한다
        Queue<Integer> queue = new LinkedList<>(); // 큐 초기화
        queue.add(start);
        visited[start] = true; // 재방문을 고려하여 방문처리
        while (!queue.isEmpty()){
            // 큐가 비지 않을때 까지 계속, 이어져있는 노드들을 탐색
            int now = queue.poll(); // 현재 비교 중인 노드를 꺼낸다
            for (int i = 1; i < n+1; i++) {
                // 연결되어있는 노드들을 중에 방문하지 않은 것들을 큐에 담기
                if(map[now][i] && !visited[i]){
                    queue.add(i);
                    visited[i] = true; // 방문처리
                }
            }
        }
    }
}
