public class Utility {

    public static String toJavaArray(String arr){
        return arr.replace("[","{").replace("]","}");
    }

    public static void main(String[] args) {
        String x = toJavaArray("[[60, 50], [30, 70], [60, 30], [80, 40]]");
        System.out.println(x);

    }
}
