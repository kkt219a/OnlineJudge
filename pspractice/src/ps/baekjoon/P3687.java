package ps.baekjoon;

//풀이 - 1시간 고민
import java.io.*;

public class P3687 {
    static long[] dp = new long[101];
    static String[] dp2 = new String[101];
    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n]+" "+dp2[n]+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static void init() {
        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10;
        dp2[2] = "1";
        dp2[3] = "7";
        long a[] = {1,7,4,2,0,8};
        for(int i=9;i<101;i++){
            long minval = Long.MAX_VALUE;
            for(int j=0;j<6;j++){
                String s = ""+dp[i-j-2]+a[j];
                minval = Math.min(minval,Long.parseLong(s));
            }
            dp[i] = minval;
        }
        for(int i=4;i<101;i++){
            dp2[i] = dp2[i-2]+"1";
        }
    }
}
