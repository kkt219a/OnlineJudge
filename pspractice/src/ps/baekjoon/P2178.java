package ps.baekjoon;
import java.io.*;
import java.util.*;

//30분 - 다시
public class P2178 {
    static boolean[][] visits;
    static int[][] maps;
    static int ans = Integer.MAX_VALUE;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        maps = new int[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
        visits = new boolean[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
        for(int i=0;i<Integer.parseInt(s[0]);i++){
            String ss = br.readLine();
            for(int j=0;j<ss.length();j++){
                maps[i][j] = ss.charAt(j)-'0';
            }
        }
        dfs(0,0,1);
        System.out.println(maps[maps.length-1][maps[0].length-1]);
    }
    public static void dfs(int x, int y,int cnt){
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0,0,0));
        while(!q.isEmpty()){
            Position poll = q.poll();
            for(int i=0;i<4;i++){
                int newX = poll.x + dx[i];
                int newY = poll.y + dy[i];
                if(newX<0||newY<0||newX>=maps.length||newY>=maps[0].length)
                    continue;
                if(visits[newX][newY]||maps[newX][newY]==0)
                    continue;
                q.add(new Position(newX,newY,poll.cnt+1));
                maps[newX][newY] = maps[poll.x][poll.y]+1;
                visits[newX][newY]=true;
            }
        }
    }
    static class Position{
        int x,y,cnt;
        public Position(int x, int y,int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
