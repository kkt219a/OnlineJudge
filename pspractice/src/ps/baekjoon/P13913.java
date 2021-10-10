package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//14:40~15:08
public class P13913 {
    static int n,k,ans;
    static int[] time = new int[100001], parent = new int[100001];
    static Queue<Integer> queue= new LinkedList<>();
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        bfs(n);
        System.out.println(time[ans]-1);
        while(parent[ans]!=-1){
            list.add(ans);
            ans = parent[ans];
        }
        list.add(ans);
        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1;i>=0;i--){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
    public static void bfs(int now){
        queue.add(now);
        time[now] = 1;
        parent[now] = -1;
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            if(k==poll){
                ans = poll;
                break;
            }
            tmpPush(poll+1,poll);
            tmpPush(poll-1,poll);
            tmpPush(poll*2,poll);
        }
    }
    public static void tmpPush(int value, int prev){
        if(value>=0&&value<=100000&&time[value]==0){
            queue.add(value);
            time[value] = time[prev]+1;
            parent[value] = prev;
        }
    }
}
