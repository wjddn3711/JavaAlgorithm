import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WordExchange {

    static String[] words;
    static int minVal = Integer.MAX_VALUE;

    public static List<Integer> getPossibleWord(String word, boolean[] visited){
        // 현재 word 에서 한개의 문자만 바뀌었을 때에 바뀔 수 있는 유망한 단어의 인덱스를 반환한다
        // 모든 단어의 길이는 같다
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int cnt = 0;
            if(!visited[i]){
                // 해당 단어로 바뀐 적이 없다면
                for (int j = 0; j < word.length(); j++) {
                    if(cnt > 1) break; // 두개이상의 문자가 차이나면 break
                    if(words[i].charAt(j) != word.charAt(j)) cnt++; // 문자가 다를때마다 +1
                }
                if(cnt==1) pos.add(i); // 만약 바뀔 수 있다면 pos 에 담아준다
            }
        }
        return pos;
    }

    public static void dfs(String begin, String target, boolean[] visited, int cnt, int visitCnt){
        // 시작점이 현재 타겟과 같다면 현재 최대값과 비교 후 return;
        if(begin.equals(target)){
            minVal = Math.min(cnt, minVal);
            return;
        }
        if(visitCnt == visited.length) return;
        // 아니라면 유망한 경우를 찾는다
        List<Integer> pos = getPossibleWord(begin,visited);
        for (Integer p : pos) {
            visited[p] = true; // 해당 유망한 경우를 선택한 경우
            dfs(words[p], target, visited, cnt+1, visitCnt+1);
        }
    }

    public static void main(String[] args) {
        words = new String[]{"hot", "dot", "dog", "lot", "log"};
        boolean[] visited = new boolean[words.length];
        dfs("hit", "cog", visited, 0,0);

        if(minVal==Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(minVal);

    }
}
