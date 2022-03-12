package ps.programmers.level1;

import java.util.Arrays;

// 연습문제 - 서울에서 김서방 찾기
// 2022/03/13 01:51~01:53 = 2분
public class FindSeoulKim {
	public String solution(String[] seoul) {
		for(int i=0;i< seoul.length;i++) {
			if (seoul[i].equals("Kim")) {
				return "김서방은 " + i + "에 있다";
			}
		}
		return "";
	}
}
