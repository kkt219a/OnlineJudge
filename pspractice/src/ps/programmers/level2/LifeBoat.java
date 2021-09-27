package ps.programmers.level2;

import java.util.*;

//탐욕법(Greedy) - 구명보트
// 18:13~18:23 = 10분
public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        for(int i=0,j= people.length-1;i<=j;){
            int total = 0;
            for(;limit>=total+people[j]&&i<=j;total+=people[j--]);
            for(;limit>=total+people[i]&&i<=j;total+=people[i++]);
            answer ++;
        }
        return answer;
    }
}
