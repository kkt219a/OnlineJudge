package ps.programmers.level2;
import java.util.*;

//스택/큐 - 기능개발
// 14:04~ 14:23 = 19분
public class FunctionDev {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i< progresses.length;i++){
            System.out.println(i);
            int nowI = i;
            int days = (100 - progresses[i]) / speeds[i];
            if((100-progresses[i])%speeds[i]!=0) days++;
            for(i++;i< progresses.length;i++){
                int otherDays = (100-progresses[i]) / speeds[i];
                if((100-progresses[i])%speeds[i]!=0) otherDays++;
                if(otherDays>days){
                    break;
                }
            }
            i--;
            answer.add(i-nowI+1);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
