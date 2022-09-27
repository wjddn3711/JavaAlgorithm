package StackQueue;

import java.util.*;

/*
여러분도 알다시피 여러분의 프린터 기기는 여러분이 인쇄하고자 하는 문서를 인쇄 명령을 받은 ‘순서대로’, 즉 먼저 요청된 것을 먼저 인쇄한다. 여러 개의 문서가 쌓인다면 Queue 자료구조에 쌓여서 FIFO - First In First Out - 에 따라 인쇄가 되게 된다. 하지만 상근이는 새로운 프린터기 내부 소프트웨어를 개발하였는데, 이 프린터기는 다음과 같은 조건에 따라 인쇄를 하게 된다.

현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.
예를 들어 Queue에 4개의 문서(A B C D)가 있고, 중요도가 2 1 4 3 라면 C를 인쇄하고, 다음으로 D를 인쇄하고 A, B를 인쇄하게 된다.

여러분이 할 일은, 현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 것이다. 예를 들어 위의 예에서 C문서는 1번째로, A문서는 3번째로 인쇄되게 된다.
 */
public class B1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 개수
        for (int i = 0; i < t; i++) {
            Queue<Node> queue = new LinkedList<Node>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐 (높은 순서대로)

            int n = sc.nextInt(); // 문서의 개수
            int m = sc.nextInt(); // 타겟 큐의 인덱스
            int cnt = 1; // 타겟이 인쇄되는데 걸리는 횟수

            for (int j = 0; j < n; j++) {
                int currPriority = sc.nextInt();
                queue.add(new Node(currPriority, j)); // 큐에 우선순위/인덱스 형태로 삽입
                pq.add(currPriority); // 우선순위 큐에 우선순위 삽입
            }

            while(true){
                int currPeak = pq.peek(); // 현재 최우선순위
                Node currNode = queue.poll(); // 큐에서 FIFO 를 빼내온다
                if(currNode.priority == currPeak){
                    // 만약 현재 노드의 우선순위가 최우선순위라면 꺼내어 준다
                    pq.poll(); // 우선순위 큐에서 우선 순위 제거
                    if(currNode.index == m){
                        // 타겟 인덱스일 경우 바로 sout
                        System.out.println(cnt);
                        break;
                    }
                    cnt++; // 아닐 경우 꺼낸 횟수 +1
                }
                else{
                    // 만약 현재 노드의 우선순위가 최우선 순위가 아닐경우
                    queue.add(currNode); // 큐의 끝에 삽입
                }
            }
        }
    }
}
class Node {
    public int priority;
    public int index;

    public Node(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}