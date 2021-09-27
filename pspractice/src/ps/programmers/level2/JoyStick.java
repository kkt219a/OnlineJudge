package ps.programmers.level2;

//탐욕법(Greedy) - 조이스틱
//40분, 미해결, 참조
public class JoyStick {
    public int solution(String name) {
        int answer = 0, length = name.length(), min = length-1;
        for(int i=0;i<length;i++){
            answer += Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);
            int idx=i+1;
            while(idx<length&&name.charAt(idx)=='A')
                idx++;
            min = Math.min(min,i*2+length-idx);
        }
        return answer+min;
    }
}
