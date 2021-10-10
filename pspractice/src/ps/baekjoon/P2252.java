package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static ps.baekjoon.P16973.a;

//18:45~19:30
public class P2252 {
    static int n,m;
    static Stack<Integer> st = new Stack<>();
    static List<List<Integer>> v = new ArrayList<>();
    static boolean[] visit = new boolean[32001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        n = Integer.parseInt(s.nextToken());
        m = Integer.parseInt(s.nextToken());
        for(int i=0;i<=n;i++){
            v.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++) {
            s = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(s.nextToken()), b = Integer.parseInt(s.nextToken());
            v.get(a).add(b);
        }
        for(int i=1;i<=n;i++){
            if(!visit[i])
                dfs(i);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop()).append(" ");
        }
        System.out.println(sb);
    }
    public static void dfs(int value){
        visit[value] = true;
        List<Integer> list = v.get(value);
        for (int i = 0; i < list.size(); i++) {
            if (!visit[list.get(i)]) {
                dfs(list.get(i));
            }
        }
        st.push(value);
    }
}
