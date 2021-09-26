package ps.programmers.level2;
import java.util.*;
// 정렬 - H-Index
//35분
public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int length = citations.length;
        for(int h=0;h<= citations[length-1];h++){
            int v = 0;
            for(int j=0;j<length;j++){
                if(citations[j]>=h){
                    v= j+1;
                    break;
                }
            }
            if(h>=v&&length-v+1>=h){
                answer = Math.max(answer,h);
            }
        }
        return answer;
    }
}
