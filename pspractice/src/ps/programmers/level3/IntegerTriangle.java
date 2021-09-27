package ps.programmers.level3;

//동적계획법(Dynamic Programming) - 정수 삼각형
//20:49~20:57
public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for(int i=1;i< triangle.length;i++){
            for(int j=0;j< triangle[i].length;j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j];
                }else if(j== triangle[i].length-1){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]);
                }
                dp[i][j]+=triangle[i][j];
            }
        }
        for (int i : dp[triangle.length - 1]) {
            answer = Math.max(answer,i);
        }
        return answer;
    }
}
