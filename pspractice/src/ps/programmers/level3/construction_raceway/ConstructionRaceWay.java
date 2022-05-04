package ps.programmers.level3.construction_raceway;

import java.awt.*;

// 2020 카카오 인턴십 - 경주로 건설
// 2022/05/04 16:18 ~ 17:21 = 63분
public class ConstructionRaceWay {
	int[][] realBoard;
	boolean[][] visited;
	int[][] minCost;
	int n;
	int[] dx = new int[]{1,0,-1,0};
	int[] dy = new int[]{0,1,0,-1};
	public int solution(int[][] board) {
		realBoard = board;
		visited = new boolean[board.length][board.length];
		minCost = new int[board.length][board.length];
		for(int i=0;i< minCost.length;i++) {
			for(int j=0;j<minCost.length;j++) {
				minCost[i][j] = Integer.MAX_VALUE;
			}
		}
		n = board.length;
		dfs(0,null, new Point(0,0));
		return minCost[n-1][n-1];
	}
	public void dfs(int cost, Point prevPoint, Point curPoint) {
		visited[curPoint.x][curPoint.y] = true;
		minCost[curPoint.x][curPoint.y] = Math.min(cost, minCost[curPoint.x][curPoint.y]);
		if(cost==minCost[curPoint.x][curPoint.y]) {
			for (int i = 0; i < 4; i++) {
				int newX = curPoint.x + dx[i];
				int newY = curPoint.y + dy[i];
				if (isAccess(newX, newY)) {
					Point newCurPoint = new Point(newX, newY);
					Point newPrevPoint = new Point(curPoint);
					int addCost = roadFee(prevPoint, newCurPoint);
					dfs(cost + addCost, newPrevPoint, newCurPoint);
				}
			}
		}
		visited[curPoint.x][curPoint.y] = false;
	}

	private int roadFee(Point prevPoint, Point newCurPoint) {
		if(prevPoint == null) {
			return 100;
		}
		return Math.abs(prevPoint.x - newCurPoint.x) == 1 && Math.abs(prevPoint.y - newCurPoint.y) == 1 ? 600:100;
	}

	public boolean isAccess(int x, int y) {
		return x>=0 && y>=0 && x<n && y<n && !visited[x][y] && realBoard[x][y] != 1;
	}

	public static void main(String[] args) {
		ConstructionRaceWay constructionRaceWay = new ConstructionRaceWay();
		int ans = constructionRaceWay.solution(new int[][] {
			{0, 0, 0, 0, 0, 0, 0, 0},
			{1, 0, 1, 1, 1, 1, 1, 0},
			{1, 0, 0, 1, 0, 0, 0, 0},
			{1, 1, 0, 0, 0, 1, 1, 1},
			{1, 1, 1, 1, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 1, 0},
			{1, 1, 1, 1, 1, 1, 1, 0},
			{1, 1, 1, 1, 1, 1, 1, 0}
		});
		System.out.println(ans);
	}
}
