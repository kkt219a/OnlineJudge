package ps.programmers.level2.joy_stick;

import java.util.Arrays;

//탐욕법(Greedy) - 조이스틱
// 2022/04/17 00:15~01:08 그리디로 풀었는데 그리디가 아니었네??
// 2022/04/17 01:08~01:35 = dfs 완탐해서 품
public class JoyStickV2 {
    char[] names;
    boolean[] visited;
    int cost;
    public int solution(String name) {
        names = name.toCharArray();
        visited = new boolean[names.length];
        return dfs(0);
    }

    public int dfs(int idx) {
        System.out.println(idx+"방문");
        visited[idx] = true; // 방문
        int tmpCost = makeAMinCost(idx); // 이걸 A로 만드는 비용 계산
        int costLeft = tmpCost, costRight = tmpCost;
        int left= idx-1 < 0 ? names.length-1 : idx-1;
        int right = idx+1 >= names.length ? 0 : idx+1;
        // 방문을 했거나, A인동안 -> 방문 안했고 A아니면 멈춤
        int i;
        for(i=1;i< names.length && (names[left]=='A' || visited[left]);left = left-1<0?names.length-1:left-1, i++);
        if(i!= names.length) {
            System.out.println(i+" "+left+"좌방문");
            costLeft += i;
            costLeft += dfs(left);
        }
        for(i=1;i< names.length && (names[right]=='A' || visited[right]);right= right+1 >= names.length ? 0 : right+1, i++);
        if(i!= names.length) {
            System.out.println(i+" "+right+"우방문");
            costRight += i;
            costRight += dfs(right);
        }
        visited[idx] = false;
        return Math.min(costLeft, costRight); // 왼, 오중 최소값 반환
    }

    public int makeAMinCost(int idx) {
        return Math.min(names[idx] - 'A', 'Z'-names[idx]+1);
    }
    public static void main(String[] args) {
        JoyStickV2 joyStickV2 = new JoyStickV2();
        System.out.println(joyStickV2.solution(	"JEROEN"));
    }

}
