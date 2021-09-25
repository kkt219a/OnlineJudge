package ps.programmers.level1;

import java.util.*;
//해시 - 완주하지 못한 선수
// 14:22 ~14:40
public class NotFinishRace {
    Map<String,Integer> member = new HashMap<>();
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        for (String s : participant) {
            member.put(s, member.getOrDefault(s,0)+1);
        }
        for (String s : completion) {
            member.put(s, member.getOrDefault(s,0)-1);
        }
        for (String s : member.keySet()) {
            if(member.get(s)!=0){
                answer=s;
                break;
            }
        }
        return answer;
    }
}
