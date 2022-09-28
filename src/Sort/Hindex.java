package Sort;

import java.util.Arrays;

public class Hindex {
    public static void main(String[] args) {
        int answer = 0;
        int[] citiation = {3, 0, 6, 1, 5};
        Arrays.sort(citiation);
        System.out.println(citiation[citiation.length/2]);
        //0,1,3,5,6
        // h 회 이상 인용된 논문 편수가 h 편 이상 이어야함 , 즉 앞에서 부터 루프를 돌면서 h 편 이상인 경우에 return 시키도록 함
        for (int i = 0; i < citiation.length; i++) {
            int h = citiation.length - i; // 오름차순으로 정렬했기 때문에 현재 부터 끝까지의 논문 정보
            if(citiation[i] >= h){
                answer = h;
                break;
            }
        }
        System.out.println(answer);
    }
}
