import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Ponkemon {
    public static void main(String[] args) {
        // 사실상 같은 종류의 수를 묻는 문제
        /*
        1. Set 을 통하여 폰켓몬 배열을 중복값 없이 만든다
        2. 만약 n/2가 set의 사이즈보다 작거나 같다면 n/2 를 반환
        3. 만약 n/2가 set의 사이즈보다 크다면 set의 사이즈를 반환
        */
        int[] nums = {3,1,2,3};
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());


        int answer = nums.length/2;
        if(answer > set.size()){
            answer = set.size();
        }
        System.out.println(answer);
    }
}
