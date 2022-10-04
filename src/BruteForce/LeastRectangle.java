package BruteForce;

import java.util.Arrays;

public class LeastRectangle {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[] length = new int[sizes.length];
        int[] width  = new int[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]){
                // 만약 가로의 길이가 세로의 길이보다 작다면 swap 해준다
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;

            }
            length[i] = sizes[i][0];
            width[i] = sizes[i][1];
        }
        Arrays.sort(length);
        Arrays.sort(width);

        int size = length[sizes.length-1]* width[sizes.length-1];
        System.out.println(size);
    }
}
