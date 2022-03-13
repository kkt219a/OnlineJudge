package ps.programmers.level1;

import java.util.Arrays;
import java.util.stream.Collectors;

// 연습문제 - 이상한 문자 만들기
// 2022/03/13 18:14~18:40
public class StrangeStringMake {
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		String[] split = s.split(" ");
		for (String s1 : split) {
			String[] chars = s1.split("");
			for(int i=0;i< chars.length;i++) {
				chars[i] = i%2 == 0 ? chars[i].toUpperCase() : chars[i].toLowerCase();
			}
			sb.append(String.join("", chars)).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		for(int i=s.length()-1;s.charAt(i)==' ';sb.append(' '), i--);
		return sb.toString();
	}
}
