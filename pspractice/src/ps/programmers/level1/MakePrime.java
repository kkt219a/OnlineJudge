package ps.programmers.level1;

// Summer/Winter Coding(~2018) - 소수 만들기
// 2022/03/02 23:00~23:05 = 5분
public class MakePrime {
	public int solution(int[] nums) {
		int n= nums.length;
		int answer = 0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					if(isPrimer(nums[i]+nums[j]+nums[k])) {
						answer++;
					}
				}
			}
		}
		return answer;
	}

	private boolean isPrimer(int number) {
		for(int i=2;i<=Math.sqrt(number);i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}

}
