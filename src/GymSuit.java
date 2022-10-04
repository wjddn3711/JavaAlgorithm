import java.util.Arrays;

public class GymSuit {

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {3};
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 각 학생은 자신의 앞이나 뒷 번호의 인원에게 빌려줄 수 있다

        // 1. 체육복을 가져 온 경우 여부를 체크
        boolean[] visited = new boolean[n+1];
        for (int i = 0; i < reserve.length; i++) {
            visited[reserve[i]] = true;
        }

        for (boolean b : visited) {
            System.out.println(b);
        }

        int answer = n- lost.length; // 초기 정답은 전체 인원 - 안가져온 인원
        // 2. 잃어버린 친구들중 앞뒤로 만약 체육복을 가져왔다면
        for (int i = 0; i < lost.length; i++) {
            if (visited[lost[i]]){
                visited[lost[i]] = false;
                answer++;
                continue;
            }
            // 앞의 학생이 가져왔을 경우
            if (visited[lost[i] - 1]) {
                visited[lost[i] - 1] = false; // 해당 인원은 이제 못 빌려줌
                answer++;
                continue;
            }
            if (lost[i]+1 < n && visited[lost[i] + 1]) {
                visited[lost[i] + 1] = false;
                answer++;
            }

        }
        System.out.println(answer);
    }
}
