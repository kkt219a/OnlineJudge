package ps.programmers.level2;
import java.util.*;

//스택/큐 - 프린터
//22분
public class Printer {
    Queue<Schedule> sq = new LinkedList<>();
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int delete = 1;
        for (int i=0;i< priorities.length;i++){
            sq.add(new Schedule(i,priorities[i]));
        }
        while(!sq.isEmpty()){
            Schedule poll = sq.poll();
            boolean success = true;
            for (Schedule schedule : sq) {
                if(schedule.priority>poll.priority){
                    success = false;
                    break;
                }
            }
            if(success){
                if(location== poll.idx){
                    answer = delete;
                    break;
                }else {
                    delete++;
                }
            }else{
                sq.add(poll);
            }
        }
        return answer;
    }
    static class Schedule{
        int idx;
        int priority;
        public Schedule(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}
