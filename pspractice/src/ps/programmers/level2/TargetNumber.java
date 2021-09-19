package ps.programmers.level2;

//깊이/너비 우선 탐색(DFS/BFS) - 타겟 넘버
// 22:29~22:39
public class TargetNumber {
    static int[] numberArray;
    static int answer=0;
    public static int solution(int[] numbers, int target) {
        numberArray = numbers;
        dfs(0, target,0);
        return answer;
    }
    public static void dfs(int sum, int target, int cur){
        if(sum==target&&cur== numberArray.length){
            answer++;
        }else if(cur< numberArray.length) {
            dfs(sum + numberArray[cur], target, cur + 1);
            dfs(sum - numberArray[cur], target, cur + 1);
        }
    }
}
