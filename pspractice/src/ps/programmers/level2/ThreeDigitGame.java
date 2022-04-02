package ps.programmers.level2;

// 2018 KAKAO BLIND RECRUITMENT - [3차] n진수 게임
// 2차 - 2022/04/02 15:46~16:07 = 21분, 좀 느리긴한데..뭐 ...!
public class ThreeDigitGame {
	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		StringBuilder ans = new StringBuilder();
		for(int i=p-1,j=0,k=0;j<t;i+=m,j++) {
			for(;sb.length() <= i;) {
				sb.append(Integer.toString(k++,n).toUpperCase());
			}
			ans.append(sb.charAt(i));
		}
		return ans.toString();
	}
}
