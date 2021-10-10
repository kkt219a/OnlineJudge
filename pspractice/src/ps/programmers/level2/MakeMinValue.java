package ps.programmers.level2;

import java.util.Arrays;

//연습문제 - 최솟값 만들기
//3분
public class MakeMinValue {
    int[] sum = new int[1000000];
    public int solution(int []A, int []B){
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0,len=A.length;i<len;i++){
            answer += (A[i]*B[len-1-i]);
        }
        return answer;
    }
}
