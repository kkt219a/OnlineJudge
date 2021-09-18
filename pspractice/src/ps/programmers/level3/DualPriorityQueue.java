package ps.programmers.level3;

import java.util.*;

//힙(Heap) - 이중우선순위큐
//21:31~21:50
public class DualPriorityQueue {
    static PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minPq = new PriorityQueue<>();
    public static int[] solution(String[] operations) {
        int[] answer = {0,0};
        for (String operation : operations) {
            String[] s = operation.split(" ");
            if(s[0].equals("D")){
                if(s[1].equals("-1")){
                    Integer exists = minPq.poll();
                    if(exists!=null) {
                        maxPq.remove(exists);
                    }
                }else{
                    Integer exists = maxPq.poll();
                    if(exists!=null) {
                        minPq.remove(exists);
                    }
                }
            }else{
                minPq.add(Integer.parseInt(s[1]));
                maxPq.add(Integer.parseInt(s[1]));
            }
        }
        if(!minPq.isEmpty()&&!maxPq.isEmpty()) {
            answer[0] = maxPq.peek();
            answer[1] = minPq.peek();
        }
        return answer;
    }
}
