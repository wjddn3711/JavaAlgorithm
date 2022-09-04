import java.util.Arrays;
/*
다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.
1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
 */

import java.util.Scanner;

public class B2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] target = new int[8];
        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < 8; i++) {
            target[i] = sc.nextInt();
        }
        for (int i = 1; i < 8; i++) {
            if(target[i-1] > target[i]) descending = false;
            else if(target[i] > target[i-1]) ascending = false;
        }
        if(ascending) System.out.println("ascending");
        else if(descending) System.out.println("descending");
        else System.out.println("mixed");
    }
}
