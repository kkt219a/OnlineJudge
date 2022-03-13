package ps.programmers.level1;

import java.util.Arrays;
import java.util.stream.Collectors;

// 연습문제 - 제일 작은 수 제거하기
// 2022/03/14 01:10~01:27
public class MinimumNumberRemove {
	public int[] solution(int[] arr) {
		if(arr.length==1){
			return new int[]{-1};
		}
		int min = Arrays.stream(arr).min().getAsInt();
		int[] ar = new int[arr.length-1];
		for(int i=0,j=0;i<arr.length;i++) {
			if(min==arr[i]) {
				continue;
			}
			ar[j++] = arr[i];
		}
		return ar;
	}
}
