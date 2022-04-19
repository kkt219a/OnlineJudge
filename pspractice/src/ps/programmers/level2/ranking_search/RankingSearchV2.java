package ps.programmers.level2.ranking_search;

import java.util.*;

//2021 KAKAO BLIND RECRUITMENT - 순위 검색
// 2022/04/19 15:05 ~ 16:10 = 65분
public class RankingSearchV2 {
	Map<String, List<Integer>> maps = new HashMap<>();
	boolean[] visited;
	List<Integer> ans = new ArrayList<>();
	public int[] solution(String[] info, String[] query) {
		for (String s : info) {
			visited = new boolean[4];
			String[] infos = s.split(" ");
			addMap(infos,0,-1,"");
		}
		for (List<Integer> value : maps.values()) {
			Collections.sort(value);
		}
		for (String content : query) {
			String[] contents = content.replace("and ", "").replace("- ","").split(" ");
			StringBuilder key = new StringBuilder();
			for(int i=0;i< contents.length-1;i++) {
				key.append(contents[i]);
			}
			List<Integer> scores = maps.get(key.toString());
			if(scores != null) {
				int idx = Collections.binarySearch(scores, Integer.parseInt(contents[contents.length - 1]), ((o1, o2) -> {
					int compare = Integer.compare(o1, o2);
					return compare == 0 ? 1 : compare;
				}));
				ans.add(idx >= 0 ? scores.size() - idx : scores.size() + idx+1);
			} else {
				ans.add(0);
			}
		}
		return ans.stream().mapToInt(Integer::intValue).toArray();
	}

	public void addMap(String[] origin, int depth, int idx, String sentence) {
		List<Integer> list = maps.getOrDefault(sentence, new ArrayList<>());
		list.add(Integer.parseInt(origin[4]));
		maps.put(sentence, list);
		if(depth<4) {
			for (int i = idx + 1; i < 4; i++) {
				if (!visited[i]) {
					visited[i] = true;
					addMap(origin, depth + 1, i, sentence + origin[i]);
					visited[i] = false;
				}
			}
		}
	}
}
