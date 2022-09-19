import java.util.*;

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class ShorestMap {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    static int[][] graph;

    public static void bfs(){
        // 시작 위치는 항상 1,1
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));

        while(!queue.isEmpty()){
            // 큐가 비지 않을 때 동안 계속 진행
            Point now = queue.poll(); // 큐에서 하나를 꺼내옴
            int x = now.x;
            int y = now.y;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 만약 맵의 안에 있으며 움직인 이후의 칸이 1이라면 이동후 바꾸어준다
                if(nx < n && ny < m && nx >= 0 && ny >= 0 && graph[nx][ny]==1){
                    graph[nx][ny] = graph[x][y] + 1; // 현재 칸에서 +1 한 값으로 바꾸어준다
                    if (nx==n && ny==m) return;
                    queue.add(new Point(nx,ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        int answer = 0;
        graph = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        n = graph.length;
        m = graph[0].length;
        bfs();
        answer = graph[n-1][m-1] == 1 ? -1 : graph[n-1][m-1];
        System.out.println(answer);
    }
}
