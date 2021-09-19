package ps.programmers.level3;

//깊이/너비 우선 탐색(DFS/BFS) - 네트워크
// 22:41~22:50
public class Network {
    static int[][] com;
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        com = computers;
        visit = new boolean[n];
        for(int i=0;i<com.length;i++){
            if(!visit[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int cur){
        for(int i=0;i<com[cur].length;i++){
            if(!visit[i]&&com[cur][i]==1&&cur!=i) {
                visit[i] = true;
                dfs(i);
            }
        }
    }
}
