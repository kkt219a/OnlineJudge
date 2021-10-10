package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//17:55~18:00 /
public class P16973 {
    static int a,b,ans;
    static String[] visit = new String[10001];
    static int[] parent = new int[10001];
    static Queue<Integer> queue= new LinkedList<>();
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++) {
            for(int j=0;j<10001;j++){
                visit[j] = ""; parent[j] = 0;
            }
            queue.clear();
            sb = new StringBuilder();
            String[] s = br.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            bfs();
            ans = b;
            while(parent[ans]!=-1){
                System.out.println("parent = " + parent[ans]+" "+ans);
                sb.append(visit[ans]);
                ans = parent[ans];
            }
            System.out.println(sb.reverse());
        }
    }
    public static void bfs(){
        queue.add(a);
        visit[a] = "T";
        parent[a] = -1;
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            System.out.println("poll = " + poll);
            if(poll==b){
                break;
            }
            d(poll);
            s(poll);
            l(poll);
            r(poll);
        }
    }

    public static void d(int v){
        int save = (v * 2) % 10000;
        if(visit[save].isBlank()){
            queue.add(save);
            visit[save] = "D";
            parent[save] = v;
        }
    }
    public static void s(int v){
        int save =  v==0 ? 9999 : v-1;
        if(visit[save].isBlank()){
            queue.add(save);
            visit[save] = "S";
            parent[save] = v;
        }
    }
    public static void l(int v){
        int save =  (v%1000)*10 + v/1000;
        if(visit[save].isBlank()){
            queue.add(save);
            visit[save] = "L";
            parent[save] = v;
        }
    }
    public static void r(int v){
        int save =  (v%10)*1000+v/10;
        if(visit[save].isBlank()){
            queue.add(save);
            visit[save] = "R";
            parent[save] = v;
        }
    }
}
