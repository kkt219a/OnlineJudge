package ps.programmers.level2;

import java.util.*;

//정렬 - 가장 큰 수
// 10분, 정렬 법칙 못찾음 다시
public class LargestNumber {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] nums = new String[numbers.length];
        for(int i=0;i< numbers.length;i++){
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        if(nums[0].equals("0"))
            return "0";
        for (String num : nums) {
            answer.append(num);
        }
        return answer.toString();
    }
}
