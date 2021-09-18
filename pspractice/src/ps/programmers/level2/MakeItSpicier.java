package ps.programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

//힙(Heap) - 더 맵게
//19:33~19:46
public class MakeItSpicier {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        int answer = 0;
        for (int j : scoville) {
            pq.offer(j);
        }
        while(pq.size()>1&&pq.peek()<K){
            Integer newVal = pq.poll()+ pq.poll() *2;
            pq.offer(newVal);
            answer++;
        }
        return pq.peek()<K ? -1 : answer;
    }
}
