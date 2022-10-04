package BruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MockExam {
    public static void main(String[] args) {
        // 각 플레이어 별로 찍는 방식을 가져옴
        int[] p1 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        List<int[]> players = Arrays.asList(p1,p2,p3);

        int[] score = new int[3]; // 각 플레이어의 점수를 저장할 배열 생성
        int[] answers = {1,2,3,4,5};
        for (int i = 0; i < answers.length; i++) {
            // 각각 index out of range 일 경우에 나머지로 반환되도록 한다
            int[] index = new int[3];
            for (int j = 0; j < 3; j++) {
                index[j] = i >= players.get(j).length ? players.get(j).length%i : i;
                if(players.get(j)[index[j]] == answers[i]){
                    // 만약 해당 인덱스의 사람이 정답일 경우 점수 +1
                    score[j] += 1;
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        int maxVal = Math.max(score[0], Math.max(score[2], score[1])); // 현재 score 배열에서 max 값을 가져온다
        for (int i = 0; i < score.length; i++) {
            if(score[i] == maxVal){
                answer.add(i+1); // 만약 최대 값일 경우 순서대로 받아준다
            }
        }
        int[] res = answer.stream().mapToInt(item -> item).toArray();
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
