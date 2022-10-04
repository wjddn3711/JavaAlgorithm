public class IsOdd {

    public static boolean isOdd(int num){
        if(num==1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            System.out.println(isOdd(i));
        }
    }
}
