package ps.programmers.level2.big_num_make;

import java.util.Stack;
import java.util.stream.Collectors;

//탐욕법(Greedy) - 큰 수 만들기
// 2022/04/15 17:50 ~ 18:10  20분, 통과
public class BigNumberMakeV2 {
    public String solution(String number, int k) {
        Stack<Character> s = new Stack<>();
        char[] chars = number.toCharArray();
        for (char aChar : chars) {
            while(!s.isEmpty() && s.peek()<aChar && k>0) {
                s.pop();
                k--;
            }
            s.push(aChar);
        }
        while(k > 0) {
            s.pop();
            k--;
        }
        return s.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
