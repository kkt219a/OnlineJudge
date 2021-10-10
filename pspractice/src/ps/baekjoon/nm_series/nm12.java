package ps.baekjoon.nm_series;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

//3m
public class nm12 {
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    static int[] number;
    static boolean[] visit;
    static Set<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        String[] s1 = br.readLine().split(" ");
        number = new int[s1.length];
        visit = new boolean[s1.length];
        for(int i=0;i<s1.length;i++){
            number[i] = Integer.parseInt(s1[i]);
        }
        Arrays.sort(number);
        dfs( 0,0,"");
        for (String s2 : set) {
            sb.append(s2).append("\n");
        }
        System.out.print(sb);
    }
    public static void dfs(int last, int now, String s){
        if(now==m){
            set.add(s);
        }else if(now<m) {
            for (int i = last; i < n; i++) {
                dfs(i,now + 1, s + number[i] + " ");
            }
        }
    }
}
