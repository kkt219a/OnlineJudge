package ps.programmers.level2;
import java.util.*;
//완전탐색 - 소수 찾기
//17:22~18:16
public class FindPrime {
    boolean[] primes = new boolean[10000000];
    Set<Integer> values = new HashSet<>();
    String[] split;
    boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;
        primeInit();
        split = numbers.split("");
        visited = new boolean[split.length];
        dfs("");
        for (Integer value : values) {
            if(!primes[value]){
                answer++;
            }
        }
        return answer;
    }
    public void primeInit(){
        primes[0] = primes[1] = true;
        for(int i=2;i*i<10000000;i++){
            if(!primes[i]) {
                for (int j = i*i; j < 10000000; j+=i) {
                    primes[j] = true;
                }
            }
        }
    }
    public void dfs(String s){
        if(s.length()!=0) {
            values.add(Integer.parseInt(s));
        }
        for (int i = 0; i < split.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(s+split[i]);
                visited[i] = false;
            }
        }
    }
}
