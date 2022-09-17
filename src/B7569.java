import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.
창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.
토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 */
public class B7569 {
    // 1 인 지점부터 시작하여 상하좌우앞뒤로 퍼지게 된다, 관건은 상하에 대한 고려를 해주어야 한다는 점, 방향벡터에 대한 설정이 필요
    // 방향 벡터에 대한 설정, dz 가 추가적으로 들어감, 기본적인 순서는 상하좌우위아래가 됨
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static int tomatoCnt; // 익혀야할 토마토의 개수
    static int[][][] graph;

    static int m,n,h;

    static Queue<Point> queue;

    // 좌표값을 저장할 객체 생성
    static class Point{
        private int z;
        private int x;
        private int y;

        public int getZ() {
            return z;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Point(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(){
        int ret = 0; // 익힌 일수

        // 큐가 비지 않을때 동안 계속 순회
        while(queue.size()>0){
            // 익은 토마토들은 동시에 익힌다고 가정, for loop 를 한번 더 거친다
            int initCase = queue.size();
            for (int j = 0; j < initCase; j++) {
                Point now = queue.poll(); // 현재 토마토를 꺼내온다
                int currZ = now.getZ();
                int currX = now.getX();
                int currY = now.getY();

                // 상하좌우로 돌면서 이동 후 위치를 계산
                for (int i = 0; i < 6; i++) {
                    int nz = currZ+dz[i];
                    int nx = currX+dx[i];
                    int ny = currY+dy[i];

                    // 맵의 범위를 벗어나면 다음 방향으로 넘김
                    if (nz < 0 || nx < 0 || ny < 0 || nz >= h || nx >= n || ny >= m) continue;
                    if (graph[nz][nx][ny] == 0){
                        // 큐에 담아주고 방문처리
                        queue.add(new Point(nz,nx,ny));
                        // 토마토의 개수 -1
                        tomatoCnt--;
                        // 토마토의 방문처리
                        graph[nz][nx][ny] = 1;
                    }
                }
            }
            ret++;
        }
        if(tomatoCnt==0) return ret-1;
        else return -1;// 모두 익히지 못한 경우, -1 반환
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] graphSize = bf.readLine().split(" ");
        m = Integer.parseInt(graphSize[0]); // 가로칸의 수 y
        n = Integer.parseInt(graphSize[1]); // 세로 칸의 수 x
        h = Integer.parseInt(graphSize[2]); // 높이 h

        queue = new LinkedList<>();
        graph = new int[h][n][m];
        tomatoCnt = 0;
        // 배열값 세팅
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < m; k++) {
                    int t = Integer.parseInt(st.nextToken());
                    if (t==0) {
                        tomatoCnt ++;
                    }
                    else if(t==1) queue.add(new Point(i,j,k)); // 1 인 경우 토마토들을 저장
                    graph[i][j][k] = t;
                }
            }
        }
        bf.close();
        if(tomatoCnt == 0) System.out.println(0); // 익혀야할 토마토가 없는경우 바로 0 반환
        else System.out.println(bfs());
    }
}
