package ps.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//연습문제 - 최댓값과 최솟값
//2분
public class MaxAndMin {
    public String solution(String s) {
        String answer = "";
        List<Integer> a = new ArrayList<>();
        String[] split = s.split(" ");
        for(String t : split){
            a.add(Integer.parseInt(t));
        }
        Collections.sort(a);
        return a.get(0)+" "+a.get(a.size()-1);
    }
}
