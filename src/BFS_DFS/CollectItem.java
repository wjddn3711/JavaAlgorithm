package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class CollectItem {
    static int[][] map = new int[51][51];
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(Point point){
        Queue<Point> queue = new LinkedList<>();
        queue.add(point); // 큐에 시작지점을 저장
        map[point.y][point.x] = 0; // 시작지점 방문처리

        while(!queue.isEmpty()){
            Point now = queue.poll(); // 큐에서 현재 위치를 꺼내온다
            for (int i = 0; i < 4; i++) {
                int nx = dx[i]+now.x;
                int ny = dy[i]+now.y;

                if(nx <= 51 && nx > 0 && ny <= 51 && ny > 0 && map[ny][nx]==1){
                    map[ny][nx] = map[now.y][now.x]+1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
    public static void fill(int[] coords){
        int x1 = 2*coords[0];
        int x2 = 2*coords[2];
        int y1 = 2*coords[1];
        int y2 = 2*coords[3];

        // x 축 채우기
        for (int i = 0; i <= x2-x1; i++) {
            int target = x1+i;
            // 해당 칸이 0일 경우에만 1로 바꾸어줌

            if(map[y1][target] == 0) map[y1][target] = 1;
            if(map[y2][target] == 0) map[y2][target] = 1;
            // 테두리 부분을 피해서 안쪽 부분만 채워줌
            if(target!=x1 && target!=x2){
                // 그 안쪽은 2로 채워줌, 만약 너비가 2초과일 경우에만 해당
                for (int j = y1+1; j < y2 ; j++) {
                    map[j][target] = 2;
                }
            }
        }
        // y 축 채우기
        for (int i = 0; i < y2-y1; i++) {
            int target = y1+i;
            // 해당 칸이 0일 경우에만 1로 바꾸어줌
            if(map[target][x1] == 0) map[target][x1] = 1;
            if(map[target][x2] == 0) map[target][x2] = 1;

        }
    }

    public static void main(String[] args) {
        int[][] arr = {{2,2,5,5},{1,3,6,4},{3,1,4,6}};
        // 맵의 크기 구하기
        for (int[] ints : arr) {
            fill(ints);
        }

        fill(arr[0]);
        fill(arr[1]);
        fill(arr[2]);
//        fill(arr[3]);
//        bfs(new Point(1,8));
        for (int i = map.length-1; i >=0; i--) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(map[6][12]);
    }
    
}
