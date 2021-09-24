package ps.programmers.level2;

import java.util.Arrays;

//2020 카카오 인턴십 - 수식 최대화
// 00:55~02:07 = 72분
public class FormulaMaximum {
    static String[][] sequence = {{"-","\\+","\\*"},{"-","\\*","\\+"},{"\\+","-","\\*"},{"\\+","\\*","-"},{"\\*","\\+","-"},{"\\*","-","\\+"}};
    public static long solution(String expression) {
        long answer = 0;
        for(int i=0;i<6;i++) {
            answer = Math.max(answer, Math.abs(calc(expression, i,0)));
        }
        return answer;
    }

    private static long calc(String expression, int seq, int num) {
        if(num==3){
            return Long.parseLong(expression);
        }
        else {
            String formula = sequence[seq][num];
            String[] split = expression.split(formula);
            long total = 0;
            for(int i=0;i< split.length;i++) {
                long value = calc(split[i], seq, num + 1);
                if(split.length==1){
                    return value;
                }else if(i==0){
                    total = value;
                }else {
                    switch (formula) {
                        case "-":
                            total -= value;
                            break;
                        case "\\*":
                            total *= value;
                            break;
                        case "\\+":
                            total += value;
                            break;
                    }
                }
            }
            return total;
        }
    }
}
