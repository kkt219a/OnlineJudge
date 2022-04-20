package ps.programmers.level1.fail_rate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//2019 KAKAO BLIND RECRUITMENT - 실패율
// 빠른 솔루션
public class FailRateV3 {
    public int[] solution(int N, int[] stages) {
        int[] count = new int[N+2];
        int[] waiting = new int[N+2];
        List<Info> infos = new ArrayList<>();
        for (int stage : stages) {
            waiting[stage]++;
        }
        count[N+1] = waiting[N+1];
        for(int i=N;i>0;i--) {
            count[i] = count[i+1]+waiting[i];
            double failRate = (count[i]==0 && waiting[i] ==0) ? 0 : (double)waiting[i] / count[i];
            infos.add(new Info(i,failRate));
        }
        return infos.stream().sorted((o1, o2) -> {
            int compare = Double.compare(o2.failRate, o1.failRate);
            return compare == 0 ? Integer.compare(o1.stage, o2.stage) : compare;
        }).mapToInt(i->i.stage).toArray();
    }

    class Info{
        int stage;
        double failRate;
        public Info(int stage, double failRate) {
            this.stage = stage;
            this.failRate = failRate;
        }
    }
}
