public class StockPrice {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length-1; i++){ // 마지막은 고려할 필요 없음
            int cnt = 0; // 떨어지지 않는 횟수 저장
            for(int j=i+1; j<prices.length; j++){
                cnt++; // 항상 1초가 지난다고 가정
                if(prices[i] > prices[j]) break;
            }
            answer[i] = cnt; // 떨어지지 않은 횟수를 정답에 저장
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
