package ps.programmers.level2.largest_number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//정렬 - 가장 큰 수
// 2022/04/15 14:07, 다시
public class LargestNumberV2 {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers).
            mapToObj(String::valueOf)
            .sorted((o1, o2) -> (o2+o1).compareTo(o1+o2))
            .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(List.of("3", "30", "34", "5", "9", "31", "91", "900","98"));
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        System.out.println(strings);
    }
}
