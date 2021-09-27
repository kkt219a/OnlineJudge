package ps.programmers.level3;

import java.util.Arrays;

//동적계획법(Dynamic Programming) - 등굣길
//20:58~21:19
public class WayToSchool {
    int[][] map;
    final int value = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map = new int[m+2][n+2];
        map[1][1] = 1;
        for (int[] puddle : puddles) {
            map[puddle[0]][puddle[1]] = -1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if((i==1&&j==1)||map[i][j]==-1) continue;
                int top = map[i][j-1], left = map[i-1][j];
                if(top==-1) top = 0;
                if(left==-1) left = 0;
                map[i][j] = (top + left)%value;
            }
        }
        return map[m][n];
    }
}
