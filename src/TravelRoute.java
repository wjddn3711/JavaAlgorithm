import java.util.*;

public class TravelRoute {

    // 방문여부를 맵의 형태로 저장
    static String[][] ticket;
    static boolean[] visited;

    static Queue<String> queue = new PriorityQueue<>();

    public static void dfs(String start, int cnt, String route){
        if(cnt == ticket.length){
            queue.add(route);
            // 만약 모든 경로를 이동하였다면
            return;
        }
        // 현재 위치에서 시작, 이어진 곳들을 방문한다
        for (int i = 0; i < ticket.length; i++) {
            if(!visited[i] && ticket[i][0]==start){
                // 현재위치이면서, 방문한적없는 루트라면
                visited[i] = true; // 방문처리
                route += "," + ticket[i][1]; // 다음 행선지를 루트에 추가
                dfs(ticket[i][1], cnt+1, route);
            }
        }
    }

    public static void main(String[] args) {
        ticket = new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        visited = new boolean[ticket.length];
        List<String> r = new ArrayList<>();
        r.add("ICN");
        dfs("ICN", 1, "ICN");
        System.out.println(queue.peek().split(","));
    }
}
