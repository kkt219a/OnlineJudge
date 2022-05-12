package ps.programmers.level3;

import java.util.*;

// 이분탐색 - 입국심사
// 2022/05/12 16:45 ~ 17:45, 해설참고
public class Immigration {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0, right = (long) n * times[times.length - 1], returnTime = Long.MAX_VALUE;
        while(left<=right) {
            long mid = (left+right)/2;
            long tempN = 0;
            for (int time : times) {
                tempN += mid / time;
            }
            if(n<=tempN) {
                right = mid-1;
                returnTime = Math.min(returnTime, mid);
            } else {
                left = mid+1;
            }
        }
        return returnTime;
    }
}
