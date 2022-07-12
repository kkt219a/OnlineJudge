package ps.programmers.level3;

import java.util.ArrayList;
import java.util.List;

// 2022/07/13 90분, 해설 참고
public class SheepAndWolf {
	int answer = 0;
	int[] info;
	List<List<Integer>> trees = new ArrayList<>();

	public static void main(String[] args) {
		SheepAndWolf sheepAndWolf = new SheepAndWolf();
		int v = sheepAndWolf.solution(new int[] {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
			new int[][] {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}});
		System.out.println(v);
	}

	public int solution(int[] info, int[][] edges) {
		this.info = info;
		for (int i = 0; i < info.length; i++) {
			trees.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			trees.get(edge[0]).add(edge[1]);
		}
		List<Integer> available = new ArrayList<>();
		available.add(0);
		dfs(0, 0, 0, available);
		return answer;
	}

	private void dfs(int idx, int s, int w, List<Integer> available) {
		if (info[idx] == 0) {
			s++;
		} else {
			w++;
		}
		if (s > w) {
			answer = Math.max(s, answer);
			List<Integer> newAvailable = new ArrayList<>(available);
			newAvailable.addAll(trees.get(idx));
			newAvailable.remove(Integer.valueOf(idx));
			// System.out.println(newAvailable+" "+idx);
			for (Integer i : newAvailable) {
				dfs(i, s, w, newAvailable);
			}
		}
	}
}
