package ps.programmers.level2;


import java.util.PriorityQueue;

//2021 카카오 채용연계형 인턴십 - 거리두기 확인하기
// 10:54~11:28
public class Distancing {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    static String[][] map = new String[5][5];
    static boolean ok = false;
    static boolean visit[][] = new boolean[5][5];
    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
        for(int i=0;i< places.length;i++){
            map = new String[5][5];
            for(int j=0;j< places[i].length;j++){
                String[] split = places[i][j].split("");
                map[j] = split;
            }
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    if(map[j][k].equals("P")){
                        check(0,j,k);
                    }
                }
            }
            if(ok){
                answer[i] = 0;
            }
            ok = false;
        }
        return answer;
    }
    private void check(int depth, int j, int k){
        visit[j][k] = true;
        if(depth==3|| map[j][k].equals("X")){ }
        //코로나
        else if(map[j][k].equals("P")&&depth!=0){
            ok = true;
        }else{
            if(j>0&&!visit[j-1][k]) {
                check(depth + 1, j - 1, k);
            }
            if(j<4&&!visit[j+1][k]) {
                check(depth + 1, j + 1, k);
            }
            if(k>0&&!visit[j][k-1]) {
                check(depth + 1, j, k - 1);
            }
            if(k<4&&!visit[j][k+1]) {
                check(depth + 1, j, k + 1);
            }
        }
        visit[j][k] = false;
    }
}
