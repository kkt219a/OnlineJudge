package ps.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 2018 KAKAO BLIND RECRUITMENT - [3차] 압축
// 2022/04/05 17:19~17:57 38분... 아... 쉬운건데... 느려서 다시...
public class Compression {
	Map<String, Integer> dictionary = new HashMap<>();
	List<Integer> answers = new ArrayList<>();
	int i=0;
	public int[] solution(String msg) {
		init();
		String[] split = msg.split("");
		for(;i< split.length;i++) {
			int idx = find(split, split.length);
			answers.add(idx);
		}
		return answers.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}

	private int find(String[] split, int length) {
		StringBuilder sb = new StringBuilder();
		while(i<length) {
			sb.append(split[i]);
			if(!dictionary.containsKey(sb.toString())) {
				dictionary.put(sb.toString(), dictionary.size()+1);
				sb.deleteCharAt(sb.length()-1);
				--i;
				break;
			}
			i++;
		}
		return dictionary.get(sb.toString());
	}


	private void init() {
		for(int i=65;i<91;i++) {
			dictionary.put(String.valueOf((char)i),dictionary.size()+1);
		}
	}

	public static void main(String[] args) {
		Compression compression = new Compression();
		System.out.println(Arrays.toString(compression.solution("KAKAO")));
	}
}
