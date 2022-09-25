public class Utility {

    public static String toJavaArray(String arr){
        return arr.replace("[","{").replace("]","}");
    }

    public static void main(String[] args) {
        String x = toJavaArray("[[\"yellow_hat\", \"headgear\"], [\"blue_sunglasses\", \"eyewear\"], [\"green_turban\", \"headgear\"]]");
        System.out.println(x);

    }
}
