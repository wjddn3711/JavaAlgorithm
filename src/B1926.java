import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다.
 */
public class B1926 {
    static int[][] arr;
    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,-1,1};
    static int n,m;

    static class Point{
        // Point 객체를 생성해준다, int 배열로서 확인하여도 되지만 객체지향적 프로그래밍을 하기위해 따로 클래스로 정의
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static int getSize(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        // 시작 위치를 큐에 담는다
        queue.add(new Point(x,y));
        // 그래프에서 시작위치를 0 으로 바꾸어 방문처리를 한다
        arr[x][y] = 0;
        int ret = 1; // 현재 칠해진 도화지를 1부터 시작

        while (queue.size()>0){
            Point now = queue.poll();
            int currX = now.getX();
            int currY = now.getY();
            // 시작점에서 상,하,좌,우로 이동하면서 이어지는 부분을 찾는다
            for (int i = 0; i < 4; i++) {
                // 이동후의 좌표 nx,ny를 미리 구한다, Array out of range 를 피하기 위해
                int nx = currX + dx[i];
                int ny = currY + dy[i];
                if (nx<0 || ny<0 || nx >= n || ny >= m){
                    // 만약 그래프의 범위를 벗어난다면 continue
                    continue;
                }
                // 만약 해당 지점이 1이라면 큐에 담고 방문처리, 카운트 +1
                if (arr[nx][ny]==1){
                    ret++;
                    arr[nx][ny] = 0;
                    queue.add(new Point(nx,ny));
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] graphSize = bf.readLine().split(" ");
        n = Integer.parseInt(graphSize[0]);
        m = Integer.parseInt(graphSize[1]);

        arr = new int[n][m];
        // 배열값 세팅
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 임의로 최대값을 설정
        int count = 0;
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 만약 해당 위치좌표가 1 이라면 시작
                if(arr[i][j] == 1){
                    int currSize = getSize(i,j);
                    // 현재 최대값을 초기화
                    maxVal = Math.max(maxVal, currSize);
                    count++;
                }
            }
        }
        System.out.println(count+"\n"+maxVal);
    }
}
