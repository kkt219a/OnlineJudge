package ps.programmers.level1.fail_rate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 2019 KAKAO BLIND RECRUITMENT - 실패율
// 2022/04/20 12:27~12:51, 15:28~15:57 = 24+29 = 53분
public class FailRateV2 {
    public int[] solution(int N, int[] stages) {
        List<Info> infos = new ArrayList<>();
        for(int i=1;i<=N;i++) {
            infos.add(new Info(i));
        }
        for (int stage : stages) {
            infos.stream().filter(s -> s.stage <= stage).forEach(s->s.up(stage));
        }
        infos.forEach(Info::calc);
        return infos.stream().sorted((o1, o2) -> {
            int compare = Double.compare(o2.failRate, o1.failRate);
            return compare == 0 ? Integer.compare(o1.stage,o2.stage) : compare;
        }).mapToInt(i-> i.stage).toArray();
    }

    class Info{
        int stage;
        int count=0;
        int waiting=0;
        double failRate=0;
        public Info(int stage) {
            this.stage = stage;
        }
        public void up(int stage) {
            if(stage==this.stage) {
                waiting++;
            }
            this.count++;
        }
        public void calc() {
            failRate = (waiting==0 && count==0) ? 0 : (double)waiting/count;
        }
    }
}
