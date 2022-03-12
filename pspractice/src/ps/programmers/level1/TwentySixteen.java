package ps.programmers.level1;

// 연습문제 - 2016년
// 2022/03/12 18:56~19:05 = 9분
public class TwentySixteen {
	public int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
	public String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
	public String solution(int a, int b) {
		for(int i=1;i<a;b += month[i-1], i++);
		return day[((b%7)+4)%7];
	}
}
