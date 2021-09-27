package ps.programmers.level3;

import java.util.HashMap;
import java.util.List;

//동적계획법(Dynamic Programming) - N으로 표현
// 21:20~
public class NExpression {
    int num, answer = 9,n;
    public int solution(int N, int number) {
        int answer = 0;
        num = number;
        n=N;
        dfs(1,N);
        return answer;
    }
    public void dfs(int depth,int value){
        if(value==num){
            answer = Math.min(answer,depth);
        }else if(depth<8&&value<32001){
            dfs(depth+1, value+n);
            dfs(depth+1, value-n);
            dfs(depth+1, value*n);
            dfs(depth+1, value/n);
            dfs(depth+1, value*10+n);
        }
    }
}
