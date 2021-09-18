package ps.programmers.level3;

import java.util.*;

//힙(Heap) - 디스크 컨트롤러
//22:01~23:00 중단 
public class DiskController {
    static PriorityQueue<Arrive> arrivePq = new PriorityQueue<>();
    static PriorityQueue<Wait> waitingPq = new PriorityQueue<>();
    static List<Integer> times = new ArrayList<>();
    public static int solution(int[][] jobs) {
        int answer = 0;
        int nowTime = 0;
        for(int i=0;i< jobs.length;i++){
            arrivePq.add(new Arrive(i,jobs[i][0],jobs[i][1]));
        }
        while(!arrivePq.isEmpty()|| !waitingPq.isEmpty()){
            // 웨이팅이 없다면 제일 도착시간 빠른거를 웨이팅에 추가하고 시간 늘려주기
            if(waitingPq.isEmpty()){
                Arrive peek = arrivePq.peek();
                waitingPq.add(new Wait(peek.idx,peek.progressTime, peek.arriveTime));
                nowTime += peek.arriveTime;
            }
            // 대기큐에서 가장 소요시간 작은 것을 빼기
            Wait peek = waitingPq.peek();
            // 도착큐에서도 빼기
            arrivePq.remove(peek);
            // 내 대기시간과 끝나는 시간 구하기
            if(peek!=null) {
                int waitingTime = nowTime - peek.arriveTime;
                int realProgressTime = nowTime + peek.progressTime;
                times.add(realProgressTime + waitingTime);
                nowTime += realProgressTime;
            }
        }
        for (Integer time : times) {
            answer+= time;
        }
        return answer / jobs.length;
    }

    static class Arrive implements Comparable<Arrive> {
        int idx;
        int arriveTime;
        int progressTime;
        public Arrive(int idx, int arriveTime, int progressTime) {
            this.idx = idx;
            this.arriveTime = arriveTime;
            this.progressTime = progressTime;
        }
        @Override
        public int compareTo(Arrive o) {
            int compare = Integer.compare(this.arriveTime, o.arriveTime);
            if(compare==0){
                compare = Integer.compare(this.progressTime,o.progressTime);
            }
            return compare;
        }
    }
    static class Wait implements Comparable<Wait> {
        int idx;
        int progressTime;
        int arriveTime;
        public Wait(int idx, int progressTime, int arriveTime) {
            this.idx = idx;
            this.progressTime = progressTime;
            this.arriveTime = arriveTime;
        }
        @Override
        public int compareTo(Wait o) {
            int compare = Integer.compare(this.progressTime, o.progressTime);
            if(compare==0){
                compare = Integer.compare(this.arriveTime, o.arriveTime);
            }
            return compare;
        }
    }

}
