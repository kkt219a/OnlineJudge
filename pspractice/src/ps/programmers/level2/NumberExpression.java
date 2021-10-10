package ps.programmers.level2;

//연습문제 - 숫자의 표현
//14분
public class NumberExpression {
    static int[] dp = new int[10012];
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        for(int i=1;i<10001;i++){
            sum = 0;
            for(int j=i;sum+j<=10000;j++){
                sum +=j;
                dp[sum]++;
            }
        }
        return dp[n];
    }
}
