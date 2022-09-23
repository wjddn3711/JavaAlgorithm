public class Utility {

    public static String toJavaArray(String arr){
        return arr.replace("[","{").replace("]","}");
    }

    public static void main(String[] args) {
        String x = toJavaArray("[[1,1,0,0,1,0],[0,0,1,0,1,0],[0,1,1,0,0,1],[1,1,0,1,1,1],[1,0,0,0,1,0],[0,1,1,1,0,0]]");
        System.out.println(x);
    }
}
