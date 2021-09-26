package ps.programmers.level1;
import java.util.*;

//완전탐색 - 모의고사
//16:56~17:13 = 17분
public class MockTest {
    int[][] persons = {{1, 2, 3, 4, 5},{2, 1, 2, 3, 2, 4, 2, 5},{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    public int[] solution(int[] answers) {
        int a=0,b=0,c=0,max;
        List<Integer> ans = new ArrayList<>();
        for(int j=0;j< answers.length;j++){
            if(answers[j]==persons[0][j%persons[0].length]) a++;
            if(answers[j]==persons[1][j%persons[1].length]) b++;
            if(answers[j]==persons[2][j%persons[2].length]) c++;
        }
        max = Math.max(Math.max(a,b),c);
        if(a==max) ans.add(1);
        if(b==max) ans.add(2);
        if(c==max) ans.add(3);
        return ans.stream().mapToInt(i->i).toArray();
    }
}
