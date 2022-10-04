public class MockingTest {

    public static String toKnumber(int n, int k) {
        String ret = "";
        while (n > 0) {
            ret = n % k + ret; // n 을 k 로 나눈 나머지를 ret의 앞에 더해줌
            n /= k; // 다음

        }
        return ret;
    }

    public static int to10number(String num, int k) {
        int len = num.length();
        int ret = 0;
        for (int i = 0; i < len; i++) {
            // 10진수로 만들어줌, 각 자리의 수*k 의 자리수 pow
            ret += Character.getNumericValue(num.charAt(len - 1 - i)) * Math.pow(k, i);
        }
        return ret;
    }

    // 에라스토테네스의 채를 활용한 소수 구하기
    public static boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 110011;
        int k = 10;
        int answer = 0;
        String[] poss = toKnumber(n,k).split("0");
        for(String p : poss){
            if(p.length()>0){
                int to10 = Integer.parseInt(p);
                if(isPrime(to10)){
                    answer++;
                }
            }

        }
        System.out.println(answer);
    }
}
