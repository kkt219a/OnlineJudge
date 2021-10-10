package ps.programmers.level2;

//연습문제 - 다음 큰 숫자
// 3분
public class NextBigNumber {
    public int solution(int n) {
        int answer = n+1;
        String nb = Integer.toBinaryString(n);
        int oneN = 0;
        for(int i=0;i<nb.length();i++)
            if(nb.charAt(i)=='1')
                oneN++;
        while(true){
            String nb2 = Integer.toBinaryString(answer);
            int oneA = 0;
            for(int i=0;i<nb2.length();i++)
                if(nb2.charAt(i)=='1')
                    oneA++;
            if(oneA==oneN)
                break;
            answer++;
        }
        return answer;
    }
}
