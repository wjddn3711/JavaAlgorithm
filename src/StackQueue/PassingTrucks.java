package StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class PassingTrucks {
    static class Truck{
        int weight;
        int spent;

        public Truck(int weight, int spent) {
            this.weight = weight;
            this.spent = spent;
        }
    }

    public static void main(String[] args) {
        int[] truck_weigths = {7,4,5,6};
        int bridge_length = 2;
        int weight = 10;



        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;

        for (int i = 0; i < truck_weigths.length; i++) {
            int truck = truck_weigths[i]; // 현재 트럭을 가져옴
            while(true){
                if(bridge.isEmpty()){
                    bridge.add(truck);
                    time++;
                    break;
                }
                else if(bridge.size()==bridge_length){
                    // 만약 현재 다리의 길이 만큼 트럭이 차있다면
                    bridge.poll(); // 가장 앞의 트럭을 꺼내온다
                }
                else{
                    // 만약 현재 다리에 추가해줄 수 있다면
                    int bWeight = bridge.stream().mapToInt(s -> s).sum(); // 현재 다리의 무게
                    if(bWeight+truck <= weight){
                        // 무게 총량을 넘지 않는다면 트럭을 넣어주고 break
                        bridge.add(truck);
                        time++;
                        break;
                    }
                    else{
                        bridge.add(0); // 무게 총량을 넘는다면 0을 채워준다
                        time++;
                    }
                }
            }
        }

        System.out.println(time+bridge_length);
    }
}
