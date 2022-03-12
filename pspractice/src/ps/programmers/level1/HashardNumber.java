package ps.programmers.level1;

// 연습문제 - 하샤드 수
// 2022/03/13 00:58~01:00 = 2분
public class HashardNumber {
	public boolean solution(int x) {
		String s = String.valueOf(x);
		int sum = 0;
		for(int i=0;i<s.length();i++) {
			sum += (s.charAt(i)-48);
		}
		return x%sum==0;
	}
}
