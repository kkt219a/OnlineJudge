package ps.programmers.level1;

import java.util.Arrays;
import java.util.stream.Collectors;

// 연습문제 - 시저 암호
// 2022/03/13 02:15~02:35 = 다시, 문제 푸는데 너무 오래 걸렸음
public class CaesarCode {
	public String solution(String s, int n) {
		String[] split = s.split("");
		return Arrays.stream(split)
			.map(sp -> convert(sp,n))
			.collect(Collectors.joining());
	} // 97-122, 65-90
	public String convert(String a, int n) {
		char c = a.charAt(0);
		if(c>64&&c<91){
			c +=n;
			if(c>90) {
				c-=25;
			}
		} else if(c>96&&c<123) {
			c += n;
			if(c>122) {
				c-=25;
			}
		}
		return Character.toString(c);
	}
}
