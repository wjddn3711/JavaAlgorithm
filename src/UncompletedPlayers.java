import java.util.Arrays;

public class UncompletedPlayers {


    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        Arrays.sort(participant);
        Arrays.sort(completion);

//        Arrays.stream(participant).forEach(s -> System.out.println(s));
//        System.out.println();
//        Arrays.stream(completion).forEach(s-> System.out.println(s));

        for (int i = 0; i < participant.length; i++) {
            if(i >= completion.length){
                System.out.println(participant[i]);
                break;
            }
            if(!participant[i].equals(completion[i])){
                System.out.println(participant[i]);
                break;
            }
        }
    }
}
