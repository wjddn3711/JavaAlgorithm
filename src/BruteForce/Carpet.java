package BruteForce;

import java.util.Arrays;

public class Carpet {

    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;

        int[] answer = new int[2];

        for (int i = 3; i <= 5000; i++) {
            for (int j = 1; j <= i; j++) {
                if(i*j == brown+yellow){
                    if(brown >= 2*i + 2*j -4){
                        answer[0] = i;
                        answer[1] = j;
                        break;
                    }
                }
            }
        }
        Arrays.stream(answer).forEach(s-> System.out.println(s));
    }
}
