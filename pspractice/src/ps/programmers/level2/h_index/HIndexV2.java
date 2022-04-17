package ps.programmers.level2.h_index;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 정렬 - H-Index
// 2022/04/18 00:31~00:47 = 16분 0135 = 3
public class HIndexV2 {
    public int solution(int[] citations) {
        int max = 0, length = citations.length;
        Arrays.sort(citations);
        for(int i=0;i<=10000;i++) {
            int j=0;
            for(;j<length;j++) {
                if(citations[j]>=i) {
                    break;
                }
            }
            if(j<=i && i<=length-j) {
                max = i;
            }
        }
        return max;
    }
}
