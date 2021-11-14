package ps.programmers.level2;
import ps.Main;

import java.util.*;
import java.util.stream.Collectors;

//스택/큐 - 다리를 지나는 트럭
// 50분
public class BridgeTruck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int nowTime = 1,bridgeNowWeight=0;
        Queue<Truck> bridgeQueue = new LinkedList<>();
        Queue<Integer> waitingQueue = new LinkedList<>();
        for (int truck_weight : truck_weights) {
            waitingQueue.add(truck_weight);
        }
        while(true){
            boolean end = true;
            while(!waitingQueue.isEmpty()){
                end = false;
                Integer poll = waitingQueue.peek();
                if(bridge_length>=bridgeQueue.size()&&bridgeNowWeight+poll<=weight){
                    waitingQueue.poll();
                    bridgeQueue.add(new Truck(poll,nowTime+bridge_length));
                    bridgeNowWeight+=poll;
                    nowTime++;
                    if(bridgeQueue.peek().endTime==nowTime){
                        Truck poll2 = bridgeQueue.poll();
                        bridgeNowWeight -= poll2.weight;
                    }
                }else{
                    break;
                }
            }
            if(!bridgeQueue.isEmpty()){
                end = false;
                Truck poll = bridgeQueue.poll();
                nowTime = poll.endTime;
                bridgeNowWeight -= poll.weight;
            }
            if(end) break;
        }
        return nowTime;
    }
    static class Truck{
        int weight,endTime;
        public Truck(int weight, int endTime) {
            this.weight = weight;
            this.endTime = endTime;
        }
    }
}
