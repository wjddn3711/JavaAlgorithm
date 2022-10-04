import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer {
    static class Document{
        int priority;
        int index;

        public Document(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Document{" +
                    "priority=" + priority +
                    ", index=" + index +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] priorites = {2, 1, 3, 2};
        int location = 2;
        Queue<Document> queue = new LinkedList<>();
        for (int i = 0; i < priorites.length; i++) {
            // 새롭게 문서를 저장한다
            Document doc = new Document(priorites[i], i);
            queue.add(doc);
        }
        int res = 0;
        while(!queue.isEmpty()){
            // 큐가 빌때까지 계속
            int maxVal = queue.stream().mapToInt(doc -> doc.priority).max().getAsInt();
            Document now = queue.poll(); // 큐에 저장된 문서를 하나씩 뽑아온다
            if(now.priority==maxVal){
                res++;
                if(now.index==location) break;
            }
            else{
                queue.add(now); // 뽑아온 큐를 다시 넣는다
            }
        }

        System.out.println(res);
    }
}
