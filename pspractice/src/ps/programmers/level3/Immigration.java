package ps.programmers.level3;

import java.util.*;

//이분탐색 - 입국심사
// 14:11~
public class Immigration {
    public long solution(int n, int[] times) {
        long answer = 0;
        int length = times.length;
        List<Immigrate> immigrates = new ArrayList<>();
        for (int time : times) {
            immigrates.add(new Immigrate(time,time));
        }
        for(int i=0;i<n-length;i++){
            immigrates.sort(Comparator.comparingLong(o -> o.nowTime+o.time));
            immigrates.get(0).nowTime += immigrates.get(0).time;
        }
        Optional<Immigrate> max = immigrates.stream().max(Comparator.comparingLong(o -> o.nowTime));
        return max.get().nowTime;
    }

    class Immigrate{
        long time, nowTime;
        public Immigrate(long time, long nowTime) {
            this.time = time;
            this.nowTime = nowTime;
        }
    }
}
