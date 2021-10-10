package ps.baekjoon.nm_series;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//13:14~13:16
public class nm4 {
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        dfs(1,0,"");
        System.out.print(sb);
    }
    public static void dfs(int last, int now, String s){
        if(now==m){
            sb.append(s).append("\n");
        }else if(now<m) {
            for (int i = last; i <= n; i++) {
                dfs(i,now + 1, s + i + " ");
            }
        }
    }
}
