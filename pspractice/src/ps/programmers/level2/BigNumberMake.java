package ps.programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

//탐욕법(Greedy) - 큰 수 만들기
//16:40~18:10 = 90분
public class BigNumberMake {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder(number);
        int i=0;
        for (;i<answer.length()-1&&k!=0;i++) {
            if (answer.charAt(i) < answer.charAt(i+1)) {
                answer.deleteCharAt(i);
                k--;
                i = (i==0)?i-1:i-2;
            }
        }
        while(k!=0){
            answer.deleteCharAt(answer.length()-1);
            k--;
        }
        return answer.toString();
    }
}
