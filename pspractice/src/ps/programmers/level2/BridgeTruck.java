package ps.programmers.level2;
import java.util.*;
import java.util.stream.Collectors;

//스택/큐 - 다리를 지나는 트럭
// 98분 - 다시
public class BridgeTruck {
    Queue<Integer> truck = new LinkedList<>();
    Queue<BridgeOnTruck> onTruck = new LinkedList<>();
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        for (int truck_weight : truck_weights) {
            truck.add(truck_weight);
        }
        int time = 1;
        int nowBridgeWeight = 0, nowBridgeTruck=0;
        while (!truck.isEmpty()||!onTruck.isEmpty()) {
            if(!onTruck.isEmpty()&&time==onTruck.peek().finishTime){
                BridgeOnTruck poll = onTruck.poll();
                nowBridgeWeight-= poll.weight;
                nowBridgeTruck--;
            }
            if(!truck.isEmpty()){
                Integer peek = truck.peek();
                if(nowBridgeWeight+peek<=weight&&nowBridgeTruck+1<=bridge_length){
                    onTruck.add(new BridgeOnTruck(peek,time+bridge_length));
                    nowBridgeWeight += peek;
                    nowBridgeTruck++;
                    truck.poll();
                }
            }
            time++;
        }
        return time-1;
    }
    static class BridgeOnTruck{
        int weight;
        int finishTime;
        public BridgeOnTruck(int weight, int finishTime) {
            this.weight = weight;
            this.finishTime = finishTime;
        }
    }
}
