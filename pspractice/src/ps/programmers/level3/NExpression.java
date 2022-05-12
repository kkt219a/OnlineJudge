package ps.programmers.level3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 동적계획법(Dynamic Programming) - N으로 표현
// 2022/05/12 15:45 ~ 16:44, 솔루션 참고
public class NExpression {
    List<Set<Integer>> dp = new ArrayList<>();
	public int solution(int N, int number) {
        int v = N;
        dp.add(new HashSet<>());
	    for(int i=1;i<9;i++) {
	        Set<Integer> newDp = new HashSet<>();
	        newDp.add(v);
	        dp.add(newDp);
	        v = (v*10) + N;
        }
	    for(int i=1;i<9;i++) {
            for(int j=1;i+j<9;j++) {
                Set<Integer> iValSet = dp.get(i);
                Set<Integer> jValSet = dp.get(j);
                Set<Integer> ijValSet = dp.get(i + j);
                for (Integer iVal : iValSet) {
                    for (Integer jVal : jValSet) {
                        ijValSet.add(iVal+jVal);
                        ijValSet.add(iVal-jVal);
                        ijValSet.add(iVal*jVal);
                        if(!jVal.equals(0)) {
                            ijValSet.add(iVal / jVal);
                        }
                    }
                }
            }
        }
	    for(int i=1;i<9;i++) {
	        if(dp.get(i).stream().anyMatch(val-> val==number)) {
	            return i;
            }
        }
	    return -1;
	}
}
