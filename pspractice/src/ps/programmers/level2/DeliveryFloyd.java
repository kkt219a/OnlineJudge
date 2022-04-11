package ps.programmers.level2;

import java.util.Arrays;

// Summer/Winter Coding(~2018) - 배달
// 2022/04/11 17:01~17:21(20)
public class DeliveryFloyd {
	static final int MAX_VALUE = 500_001;
	int[][] map;
	public int solution(int N, int[][] road, int K) {
		int answer = 0;
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
					map[i][j] = i==j ? 0 : MAX_VALUE;
			}
		}
		for (int[] infos : road) {
			int value = map[infos[0]-1][infos[1]-1];
			map[infos[0]-1][infos[1]-1] = Integer.min(infos[2],value);
			map[infos[1]-1][infos[0]-1] = Integer.min(infos[2],value);
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					map[j][k] = Math.min(map[j][i] + map[i][k], map[j][k]);
				}
			}
		}
		for(int i=0;i<N;i++) {
			if(map[0][i]<=K) {
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[][] ints = new int[5][5];
		System.out.println(Arrays.toString(ints[0]));
	}
}
