package ps.programmers.level1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 연습문제 - 문자열 내 마음대로 정렬하기
// 2022/03/13 01:12~01:22 = 10분
public class StringSortAsOnePleases {
	public String[] solution(String[] strings, int n) {
		List<Letter> letters = new ArrayList<>();
		for (String name : strings) {
			letters.add(new Letter(name, name.substring(n,n+1)));
		}
		return letters.stream().sorted().map(Letter::getName).toArray(String[]::new);
	}

	static class Letter implements Comparable<Letter> {
		String name;
		String character;

		public String getName() {
			return name;
		}

		public Letter(String name, String character) {
			this.name = name;
			this.character = character;
		}

		@Override
		public int compareTo(Letter o) {
			int comp = character.compareTo(o.character);
			return comp == 0 ? name.compareTo(o.name) : comp;
		}
	}
}
