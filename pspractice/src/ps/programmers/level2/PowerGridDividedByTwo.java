package ps.programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 위클리 챌린지 - 전력망을 둘로 나누기
// 2022/04/13 18:16~18:48 = 32분 어,,,,, 하니까 되네... 왜 답봤지... 다시
public class PowerGridDividedByTwo {
	List<List<Integer>> trees = new ArrayList<>();
	int min = Integer.MAX_VALUE;
	// wires를 통해서
	public int solution(int n, int[][] wires) {
		for(int i=0;i<n;i++) {
			trees.add(new ArrayList<>());
		}
		for (int[] wire : wires) {
			trees.get(wire[0]-1).add(wire[1]-1);
			trees.get(wire[1]-1).add(wire[0]-1);
		}
		for (int[] wire : wires) {
			trees.get(wire[0]-1).remove(Integer.valueOf(wire[1]-1));
			trees.get(wire[1]-1).remove(Integer.valueOf(wire[0]-1));
			bfs();
			trees.get(wire[0]-1).add(wire[1]-1);
			trees.get(wire[1]-1).add(wire[0]-1);
		}
		return min;
	}

	private void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		int cnt = 0;
		boolean[] visited = new boolean[trees.size()];
		while(!queue.isEmpty()) {
			Integer nowPoint = queue.poll();
			visited[nowPoint] = true;
			cnt++;
			for(int i=0;i< trees.get(nowPoint).size(); i++) {
				if(!visited[trees.get(nowPoint).get(i)]) {
					queue.offer(trees.get(nowPoint).get(i));
				}
			}
		}
		min = Math.min(Math.abs(trees.size()-2*cnt),min);
	}
}
