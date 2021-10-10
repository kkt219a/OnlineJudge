package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//20:10~20:50
public class P15558 {
    static int n,k;
    static boolean pass;
    static String left, right;
    static Queue<Me> queue = new LinkedList<>();
    static boolean[][] visit = new boolean[200001][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        n = Integer.parseInt(s.nextToken());
        k = Integer.parseInt(s.nextToken());
        left = br.readLine();
        right = br.readLine();
        bfs();
        System.out.println(pass?1:0);
    }
    public static void bfs(){
        queue.add(new Me(0,0,'L'));
        while(!queue.isEmpty()){
            Me poll = queue.poll();
            int idx = poll.dir == 'L' ? 0 : 1;
            if(visit[poll.idx][idx]){
                continue;
            }
            visit[poll.idx][idx] = true;
            if(poll.idx>=n){
                pass = true;
                break;
            }
            if((poll.dir=='L'&&left.charAt(poll.idx)!='0')
            ||poll.dir=='R'&&right.charAt(poll.idx)!='0') {
                add(poll.idx + 1, poll.cnt + 1, poll.dir);
                add(poll.idx - 1, poll.cnt + 1, poll.dir);
                add(poll.idx + k, poll.cnt + 1, poll.opponent());
            }
        }
    }
    public static void add(int idx, int cnt, char dir){
        if(idx>=0&&idx>=cnt){
            queue.add(new Me(idx,cnt,dir));
        }
    }
    static class Me{
        int idx,cnt; char dir;
        public Me(int idx, int cnt, char dir) {
            this.idx = idx;
            this.cnt = cnt;
            this.dir = dir;
        }
        public char opponent(){
            return this.dir=='L' ? 'R' : 'L';
        }
    }
}
