public class Utility {

    public static String toJavaArray(String arr){
        return arr.replace("[","{").replace("]","}");
    }

    public static void main(String[] args) {
        String x = toJavaArray("[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]");
        System.out.println(x);

    }
}
