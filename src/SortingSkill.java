import java.util.Arrays;
import java.util.Comparator;

public class SortingSkill {

    public static void main(String[] args) {

        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n)==o2.charAt(n)){
                    return o1.compareTo(o2);
                }
                return o1.charAt(n)-o2.charAt(n);
            }
        });



        Arrays.stream(strings).forEach(s -> System.out.println(s));
    }
}
