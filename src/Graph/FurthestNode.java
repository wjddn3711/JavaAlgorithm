package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FurthestNode {
    static int[][] vertex;
    static int[][] graph;
    static int[] distance;

    public static void bfs(){
        boolean[] visited = new boolean[vertex.length+1];
        int start = 1;
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        distance[1] = 1; // 자기 자신의 거리는 1로
        while(!queue.isEmpty()){
            int now = queue.poll(); // 큐에서 노드를 하나 꺼낸다
            for (int i = 1; i < vertex.length+1; i++) {
                if(!visited[i] && graph[now][i]!=0){
                    // 해당 부분이 이어져 있다면
                    visited[i] = true;
                    distance[i] = distance[now]+1;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        vertex = new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        graph = new int[vertex.length+1][vertex.length+1];
        for (int i = 0; i < vertex.length; i++) {
            // 그래프에서 이어진 부분을 처리한다
            graph[vertex[i][0]][vertex[i][1]] = 1;
            graph[vertex[i][1]][vertex[i][0]] = 1;
        }

        distance = new int[vertex.length+1];

        bfs();
        int answer = 0;
        int maxVal = Arrays.stream(distance).max().getAsInt();
        for (int i = 1; i < vertex.length+1; i++) {
            if(distance[i] == maxVal) answer++;
        }
        System.out.println(answer);
    }

}
