package ps.programmers.level1;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

// 2018 KAKAO BLIND RECRUITMENT - [1차] 뉴스 클러스터링
// 2022/03/16 23:55 ~ 00:47 = 53분 너무느려!
public class NewsClustering {
	public int solution(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		Map<String,Integer> str1s = getMap(str1);
		Map<String,Integer> str2s = getMap(str2);
		int duplicate = 0;
		int sum = 0;
		for (Map.Entry<String, Integer> entry1 : str1s.entrySet()) {
			Integer value = str2s.get(entry1.getKey());
			if(value!=null) {
				duplicate += Math.min(value, entry1.getValue());
				sum += Math.max(value, entry1.getValue());
				str2s.remove(entry1.getKey());
			} else {
				sum += entry1.getValue();
			}
		}
		for (Map.Entry<String, Integer> entry2 : str2s.entrySet()) {
			sum += entry2.getValue();
		}
		if(duplicate==0&&sum==0) {
			return 65536;
		}
		int answer = (int)Math.floor(((double)duplicate/sum)*65536);
		return answer;
	}

	public Map<String,Integer> getMap(String s) {
		Map<String,Integer> ss = new HashMap<>();
		for(int i=1;i<s.length();i++) {
			String value = s.substring(i - 1, i + 1);
			if(value.replaceAll("[^a-z]","").length() != value.length()){
				continue;
			}
			ss.put(value,ss.getOrDefault(value,0)+1);
		}
		return ss;
	}

}
