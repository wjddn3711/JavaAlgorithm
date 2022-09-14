import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // 1 : enqueue , 2 : dequeue front element, 3: print the front element
        Queue<Integer> queue    = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        // number of queries
        int q                   = sc.nextInt();

        for (int i = 0; i < q; i++) {
            // read input type and element
            int type            = sc.nextInt();

            if (type == 1){
                int target      = sc.nextInt();
                // insert queue
                queue.add(target);
            }
            else if(type == 2){
                // deque front element
                queue.poll();
            }
            else {
                // print the peek
                System.out.println(queue.peek());
            }
        }

    }
}
