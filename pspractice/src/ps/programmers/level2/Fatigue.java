package ps.programmers.level2;

//17:28~17:44 - 피로도
public class Fatigue {
    int answer = -1;
    boolean[] visits = new boolean[8];
    int[][] dungeonList;
    // k 현재 본인 피로도, dungenons - 각 던전별 최소/소모 피로도, 최대 던전수를 리턴!
    public int solution(int k, int[][] dungeons) {
        dungeonList = dungeons;
        dfs(k,0);
        return answer;
    }
    public void dfs(int now,int depth){
        answer = Math.max(answer,depth);
        for(int i=0;i< dungeonList.length;i++){
            if(!visits[i]&&now-dungeonList[i][0]>=0){
                visits[i] = true;
                dfs(now-dungeonList[i][1],depth+1);
                visits[i] = false;
            }
        }
    }
}
