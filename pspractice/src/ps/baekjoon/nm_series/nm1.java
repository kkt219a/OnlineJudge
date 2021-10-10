package ps.baekjoon.nm_series;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//12;16~12:30 = 14분
public class nm1 {
    static boolean[] visit = new boolean[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        dfs(n,m,0,"");
    }
    public static void dfs(int n, int m, int now, String s){
        if(now==m){
            System.out.println(s);
        }else if(now<m) {
            for (int i = 1; i <= n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(n, m, now + 1, s + i + " ");
                    visit[i] = false;
                }
            }
        }
    }
}
