package ps.programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

//정렬 - K번째수
// 01:34~01:49 = 15분
public class KNumber {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answers = new ArrayList<>();
        for (int[] command : commands) {
            int[] ints = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(ints);
            answers.add(ints[command[2]-1]);
        }
        return answers.stream().mapToInt(i->i).toArray();
    }
}
