import java.nio.channels.Pipe;
import java.util.*;
import java.util.stream.Collectors;

public class FillPuzzle {
    // 상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] board;

    static int[][] blocks;

    static int countBlock;


    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static String rotateBoard(String block){
        // 2차원 배열 90도 회전
        String[] ar = block.split("n");
        String[][] arr = new String[ar.length][ar[0].length()];
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length(); j++) {
                arr[i][j] = ar[i].charAt(j)+"";
            }
        }
        // 돌리고 string 으로 만들기
        int n = arr.length;
        int m = arr[0].length;

        String newBoard = "";

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newBoard += arr[n-1-j][i];
            }
            newBoard+="n";
        }

        return newBoard.substring(0, newBoard.length()-1);
    }

    public static String blockToString(int minX, int maxX, int minY, int maxY, List<Point> block){
        int[][] blockArr = new int[maxX - minX + 1][maxY - minY + 1];
        for (Point p : block)
            blockArr[p.x - minX][p.y - minY] = 1;
        String blockString = "";
        for (int i = 0; i < blockArr.length; i++) {
            for (int j = 0; j < blockArr[0].length; j++)
                blockString += blockArr[i][j];
            blockString += "n";
        }
        return blockString.substring(0,blockString.length()-1);
    }

    public static String getBlock(Point start){
        // 블럭들 갖고오기
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        // 스트링으로 만들기 위해 범위를 저장
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        // 해당 위치를 갖는 포인트를 저장
        List<Point> block = new ArrayList<>();
        blocks[start.x][start.y] = 0; // 재방문 하지 않도록 방문처리
        while(!queue.isEmpty()){
            Point now = queue.poll();
            // 현재 범위값 업데이트
            minX = Math.min(minX, now.x);
            maxX = Math.max(maxX, now.x);
            minY = Math.min(minY, now.y);
            maxY = Math.max(maxY, now.y);
            block.add(new Point(now.x,now.y));

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < blocks.length && ny < blocks.length && nx >= 0 && ny >= 0 && blocks[nx][ny] == 1){
                    // 맵 범위 안, 그리고 방문하지 않은곳이라면
                    queue.add(new Point(nx,ny));
                    // 해당 블럭의 위치 정보를 저장
                    blocks[nx][ny] = 0; // 해당 위치 방문처리
                }
            }
        }
        return blockToString(minX,maxX,minY,maxY,block);
    }

    public static String getBlank(Point start){
        // 블럭들 갖고오기
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        // 스트링으로 만들기 위해 범위를 저장
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        // 해당 위치를 갖는 포인트를 저장
        List<Point> block = new ArrayList<>();
        block.add(start); // 시작점을 블럭에 저장
        board[start.x][start.y] = 1; // 재방문 하지 않도록 방문처리
        while(!queue.isEmpty()){
            Point now = queue.poll();
            // 현재 범위값 업데이트
            minX = Math.min(minX, now.x);
            maxX = Math.max(maxX, now.x);
            minY = Math.min(minY, now.y);
            maxY = Math.max(maxY, now.y);

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < board.length && ny < board.length && nx >= 0 && ny >= 0 && board[nx][ny] == 0){
                    // 맵 범위 안, 그리고 방문하지 않은곳이라면
                    queue.add(new Point(nx,ny));
                    // 해당 블럭의 위치 정보를 저장
                    block.add(new Point(nx,ny));
                    board[nx][ny] = 1; // 해당 위치 방문처리
                }
            }
        }
        return blockToString(minX,maxX,minY,maxY,block);
    }

    public static void main(String[] args) {
        board = new int[][]{{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] saveBlock = new int[][]{{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};


        blocks = saveBlock.clone();
        /*
        1. 조각은 회전할 수는 있지만 뒤집는거 불가능
        2. 보드에는 빈공간을 허용하지 않고 딱 맞는 블럭이 들어가야함
        3. 블럭의 개수는 1~6개

        블럭의 모양을 어떻게 저장?

         */
        List<String> blanks = new ArrayList<>();
        Set<String> puzzle = new HashSet<>();


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 0) {
                    blanks.add(getBlank(new Point(i,j)));
                }
                if(blocks[i][j] == 1){
                    puzzle.add(getBlock(new Point(i,j)));
                }
            }
        }
        int ret = 0;
        for (String s : puzzle) {
            if (s=="1"){
                blanks.remove(s);
                continue;
            }
            if(blanks.contains(s)){
                ret += Math.toIntExact(s.chars().filter(c -> c == '1').count());
                blanks.remove(s);
            }
            else{
                for (int i = 0; i < 4; i++) {
                    String temp = rotateBoard(s);
                    if(blanks.contains(temp)){
                        ret += Math.toIntExact(s.chars().filter(c -> c == '1').count());
                        blanks.remove(temp);
                        break;
                    }
                }
            }
        }
        System.out.println(ret);
    }
}
