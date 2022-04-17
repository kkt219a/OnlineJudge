package ps.programmers.level2.distancing;

import java.util.ArrayList;
import java.util.List;

//2021 카카오 채용연계형 인턴십 - 거리두기 확인하기
// 2022/04/18 01:20 ~ 01:58 = 38분
public class DistancingV2 {
    String[][] maps;
    boolean[][] visited;
    boolean onlyChecked;
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};

    public int[] solution(String[][] places) {
        List<Integer> checks = new ArrayList<>();
        for (String[] place : places) {
            int val = check(place) ? 1 : 0;
            checks.add(val);
        }
        return checks.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean check(String[] places) {
        onlyChecked = true;
        maps = new String[5][5];
        visited = new boolean[5][5];
        for(int i=0;i<places.length;i++) {
            maps[i] = places[i].split("");
        }
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                if(maps[i][j].equals("P")) {
                    dfs(0,i,j);
                    if(!onlyChecked) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void dfs(int depth, int x, int y) {
        visited[x][y] = true;
        if(depth != 0 && maps[x][y].equals("P")) {
            onlyChecked = false;
        } else if(depth < 2 && !maps[x][y].equals("X")) {
            for (int i = 0; i < 4; i++) {
                int tmpX = x + dx[i];
                int tmpY = y + dy[i];
                if (tmpX >= 0 && tmpX <= 4 && tmpY >= 0 && tmpY <= 4 && !visited[tmpX][tmpY]) {
                    dfs(depth + 1, tmpX, tmpY);
                }
            }
        }
        visited[x][y] = false;
    }

}
