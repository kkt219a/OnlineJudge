package ps.programmers.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Summer/Winter Coding(~2018) - 영어 끝말잇기
// 2022/03/21 18:37~18:50 = 13분
public class EnglishWordRelay {
	public int[] solution(int n, String[] words) {
		Set<String> wordSet = new HashSet<>();
		Map<Integer, Integer> personMap = new HashMap<>();
		String lastWord = " ";
		int person = 0;
		for (String word : words) {
			person = (person == n ? 1 : person+1);
			personMap.put(person,personMap.getOrDefault(person,0)+1);
			if(!lastWord.equals(" ") && (wordSet.contains(word) || lastWord.charAt(lastWord.length()-1) != word.charAt(0))) {
				return new int[]{person, personMap.get(person)};
			}
			wordSet.add(word);
			lastWord = word;
		}
		return new int[]{0,0};
	}
}
