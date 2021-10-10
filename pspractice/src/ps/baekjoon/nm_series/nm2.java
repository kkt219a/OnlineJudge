package ps.baekjoon.nm_series;

import java.io.*;

//12;44~12:47
public class nm2 {
    static boolean[] visit = new boolean[9];
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        dfs(1,0,"");
    }
    public static void dfs(int last, int now, String s){
        if(now==m){
            System.out.println(s);
        }else if(now<m) {
            for (int i = last; i <= n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(i,now + 1, s + i + " ");
                    visit[i] = false;
                }
            }
        }
    }
}
