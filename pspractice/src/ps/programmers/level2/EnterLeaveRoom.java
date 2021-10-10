package ps.programmers.level2;
import java.util.*;

//29분+틀림
public class EnterLeaveRoom {
    static Stack<Integer> waiting = new Stack<>();
    static Stack<Integer> temp = new Stack<>();
    public int[] solution(int[] enter, int[] leave) {
        int[] ans = new int[enter.length];
        for(int n:enter){ waiting.push(n); }
        for(int i=0;i<leave.length;i++){
            while(!waiting.isEmpty()&&leave[i]!=waiting.peek()){
                temp.push(waiting.pop());
            }
            if(!waiting.isEmpty()){
                int v = waiting.pop();
                int size = waiting.size();
                ans[v-1]+=size;
                while(!waiting.isEmpty()){
                    int v2 = waiting.pop();
                    temp.push(v2);
                    ans[v2-1]+=size;
                }
                while(!temp.isEmpty()){
                    waiting.push(temp.pop());
                }
            }
        }
        return ans;
    }

}
