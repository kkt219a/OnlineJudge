package ps.baekjoon.nm_series;

import java.io.*;

//12;48~13;05
public class nm3 {
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        dfs(0,"");
        System.out.print(sb);
    }
    public static void dfs(int now, String s){
        if(now==m){
            sb.append(s).append("\n");
        }else if(now<m) {
            for (int i = 1; i <= n; i++) {
                dfs(now + 1, s + i + " ");
            }
        }
    }
}
