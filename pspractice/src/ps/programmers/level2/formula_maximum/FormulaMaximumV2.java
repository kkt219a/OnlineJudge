package ps.programmers.level2.formula_maximum;

import java.util.ArrayList;
import java.util.List;

//2020 카카오 인턴십 - 수식 최대화
// 2022/04/18 15:53~16:50 =57분
public class FormulaMaximumV2 {
    char[][] op = new char[][]{{'+','-','*'}, {'+','*','-'}, {'-','+','*'}, {'-','*','+'}, {'*','-','+'}, {'*','+','-'}};
    List<Character> ops = new ArrayList<>();
    List<Long> numbers = new ArrayList<>();
    long ans = Long.MIN_VALUE;
    public long solution(String expression) {
        int start = 0;
        for(int i=0;i<expression.length();i++) {
            if(!Character.isDigit(expression.charAt(i))) {
                numbers.add(Long.parseLong(expression.substring(start,i)));
                ops.add(expression.charAt(i));
                start = i+1;
            }
        }
        numbers.add(Long.parseLong(expression.substring(start)));
        for(int i=0;i< op.length;i++) {
            ans = Math.max(ans, calc(op[i]));
        }
        return ans;
    }

    private long calc(char[] seq) {
        List<Character> tmpOps = new ArrayList<>(ops);
        List<Long> tmpNumbers = new ArrayList<>(numbers);
        for (char s : seq) {
            while(tmpOps.contains(s)) {
                int idx = tmpOps.indexOf(s);
                tmpOps.remove(idx);
                long a1 = tmpNumbers.remove(idx);
                long a2 = tmpNumbers.remove(idx);
                tmpNumbers.add(idx, calcValue(a1,a2,s));
            }
        }
        return Math.abs(tmpNumbers.get(0));
    }

    private long calcValue(long a1, long a2, char op) {
        if(op=='+') {
            return a1+a2;
        } else if(op=='-') {
            return a1-a2;
        }
        return a1*a2;
    }
}
