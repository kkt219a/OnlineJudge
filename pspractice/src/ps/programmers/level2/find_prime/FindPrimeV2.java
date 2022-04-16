package ps.programmers.level2.find_prime;

import java.util.HashSet;
import java.util.Set;

//완전탐색 - 소수 찾기
// 2022/04/16 23:47~00:04 = 17
public class FindPrimeV2 {
    boolean[] isPrime = new boolean[10000000];
    char[] numberArray;
    boolean[] visited;
    Set<Integer> numberSet = new HashSet<>();
    public int solution(String numbers) {
        numberArray = numbers.toCharArray();
        visited = new boolean[numberArray.length];
        checkPrime();
        dfs("");
        System.out.println(numberSet);
        return (int)numberSet.stream().filter(n -> !isPrime[n]).count();
    }

    public void dfs(String s) {
        if(s.length() != 0) {
            numberSet.add(Integer.parseInt(s));
        }
        if(s.length() < numberArray.length) {
            for (int i = 0; i < numberArray.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(s + numberArray[i]);
                    visited[i] = false;
                }
            }
        }
    }

    public void checkPrime() {
        for(int i=2;i<Math.sqrt(10000000);i++) {
            if(!isPrime[i]) {
                for (int j = i*i; j < 10000000; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        FindPrimeV2 findPrimeV2 = new FindPrimeV2();
        findPrimeV2.checkPrime();
        for(int i=0;i<100;i++) {
            System.out.println(i+" "+findPrimeV2.isPrime[i]);
        }
    }

}
