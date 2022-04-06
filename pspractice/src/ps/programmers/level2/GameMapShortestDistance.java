package ps.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

// 찾아라 프로그래밍 마에스터 - 게임 맵 최단거리
// 2022/04/06 14:31~15:04 = 33분, 다시
public class GameMapShortestDistance {
	// 4방향으로 간다. 맵이 갈 수 없는 경우는 방문하지 않는다(범위 벗어나기, 0인 경우). 매번 갈때마다 카운트를 올린다.
	int[] dx = {1,0,-1,0};
	int[] dy = {0,-1,0,1};
	int[][] maps;
	boolean[][] visit;
	int width, height;
	int answer = -1;
	public int solution(int[][] maps) {
		this.maps = maps;
		width = maps[0].length;
		height = maps.length;
		visit = new boolean[height][width];
		bfs();
		return answer;
	}

	private void bfs() {
		Queue<Coord> coords = new LinkedList<>();
		coords.add(new Coord(0, 0, 1));
		while(!coords.isEmpty()) {
			Coord poll = coords.poll();
			if(poll.x == width-1 && poll.y == height-1) {
				answer = poll.count;
				break;
			}
			for(int i=0;i<4;i++) {
				int moveX = poll.x + dx[i];
				int moveY = poll.y + dy[i];
				if(moveX < width && moveX >= 0 && moveY <height && moveY >= 0 && maps[moveY][moveX] != 0 && !visit[moveY][moveX]) {
					coords.add(new Coord(moveX,moveY, poll.count+1));
					visit[moveY][moveX] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		GameMapShortestDistance gameMapShortestDistance = new GameMapShortestDistance();
		gameMapShortestDistance.solution(new int[][]{{1,1}});
	}

	public class Coord {
		int x, y, count;

		public Coord(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
