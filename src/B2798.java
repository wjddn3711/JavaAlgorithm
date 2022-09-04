/*
카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.
한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
 */

import java.util.Scanner;

public class B2798 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 카드의 개수
        int m = sc.nextInt(); // 카드 합의 한도

        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = sc.nextInt(); // 카드 값 받아오기
        }


        // brute force 식으로 한다면 맨처음 카드 한장을 뽑고 다음은 그 카드를 제외한 나머지 카드, 다음은 그 카드를 제외한 나머지 카드를 뽑아 m을 넘지 않으면서 최대값을 구한다
        // 총 경우의 수는 n*(n-1)*(n-2)
        Loop1:
        for (int i = 0; i < n; i++) {
            Loop2:
            for (int j = i+1; j < n; j++) {
                Loop3:
                for (int k = j+1; k < n; k++) {
                    int now = target[i]+target[j]+target[k];
                    if(now <= m && now > answer) answer = now;
                    if(answer == m) break Loop1; // m 과 값이 같다면 break;
                }
            }
        }
        System.out.println(answer);
    }
}
