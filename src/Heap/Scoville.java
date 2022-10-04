package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Scoville {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        Queue<Integer> queue = new PriorityQueue<>();
        int k = 7;
        for (int i : scoville) {
            queue.add(i);
        }

        int res = 0;
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now < k){
                // 만약 현재 스코빌 지수가 k 보다 작다면 새롭게 섞어 준다
                if(queue.isEmpty()){
                    // 만약 큐가 비어있다면 break;
                    res = -1;
                    break;
                }
                int second = queue.poll();
                queue.add(now+2*second); // 둘을 섞고 큐에 담는다
                res++;
            }
            else break; // 최소 힙에서 최소값이 k 이상인 경우 바로 종료
        }
        System.out.println(res);
    }
}
