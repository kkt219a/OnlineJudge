package ps.programmers.level3.shared_taxi_fare;

import java.util.PriorityQueue;
import java.util.Queue;

import ps.programmers.level2.DeliveryDijkstraArray;

// 2021 KAKAO BLIND RECRUITMENT - 합승 택시 요금
// 2022/05/02 21:15~22:13, 해설참조
public class SharedTaxiFareFloyd {
	static final int MAX_WEIGHT = Integer.MAX_VALUE/4;
	int[][] map;

	public int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = Integer.MAX_VALUE;
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = i==j ? 0 : MAX_WEIGHT;
			}
		}
		for (int[] fare : fares) {
			map[fare[0]-1][fare[1]-1] = fare[2];
			map[fare[1]-1][fare[0]-1] = fare[2];
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					map[j][k] = Math.min(map[j][i] + map[i][k], map[j][k]);
				}
			}
		}
		for(int i=0;i<n;i++) {
			answer = Math.min(answer, map[s-1][i]+map[i][a-1]+map[i][b-1]);
		}
		return answer;
	}
}
