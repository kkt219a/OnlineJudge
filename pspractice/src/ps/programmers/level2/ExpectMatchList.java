package ps.programmers.level2;

// 2017 팁스타운 - 예상 대진표
// 2022/03/25 09:29~09:45 = 16분
public class ExpectMatchList {
	public int solution(int n, int a, int b) {
		int answer = 0;
		while(a!=b) {
			answer++;
			a = a%2==0 ? a/2 : (a+1)/2;
			b = b%2==0 ? b/2 : (b+1)/2;
		}
		return answer;
	}
}
