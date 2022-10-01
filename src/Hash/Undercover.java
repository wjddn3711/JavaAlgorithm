package Hash;

import java.util.*;
public class Undercover {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Map<String, Integer> closet = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String clothe = clothes[i][1];
            if(closet.containsKey(clothe)){
                // 만약 해당 키를 가진 경우가 있다면 , 현재의 +1
                closet.put(clothe,closet.get(clothe)+1);
            }
            else{
                closet.put(clothe, 1);
            }
        }

        int ret = 1;
        // 모든 경우의 수를 구하려면 각 옷의 종류별로 곱해준다
        // 각 옷당 안입는 경우를 고려하여 +1 한 채로 곱해준다 단 최소 한개의 의상을 입기때문에 -1 해준다
        for(String cloth : closet.keySet()){
            ret *= closet.get(cloth) + 1;
        }
        System.out.println(ret-1);
    }
}
