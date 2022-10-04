package Sort;

import java.util.Arrays;
import java.util.Comparator;

public class Phonebook {


    public static void main(String[] args) {
        boolean answer = true;
        String[] phone_book = {"123","456","789"};
        // 하나의 번호가 다른 하나의 번호의 prefix 인 경우를 찾는다
        Arrays.sort(phone_book);
        // 비교해야할 지점은 i번째 번호의 전체가 0~length 만큼 일치하는지 확인하는것

        for (int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }

        System.out.println(answer);
    }
}
