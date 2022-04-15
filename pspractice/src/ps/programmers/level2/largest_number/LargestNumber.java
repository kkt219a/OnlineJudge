package ps.programmers.level2.largest_number;

import java.util.Arrays;
import java.util.stream.Collectors;

//정렬 - 가장 큰 수
// 10분, 정렬 법칙 못찾음 다시
public class LargestNumber {
    public String solution(int[] numbers) {
        String ans = Arrays.stream(numbers).
            mapToObj(String::valueOf)
            .sorted((o1, o2) -> (o2+o1).compareTo(o1+o2))
            .collect(Collectors.joining());
        return ans.charAt(0)=='0' ? "0" :ans;
    }
}
