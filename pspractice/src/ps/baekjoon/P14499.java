package ps.baekjoon;

// 2022/07/07 22:22 ~ 23:27 = 65분
public class P14499 {
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int n, m, x, y, k;
	static int[] da = new int[4], db = new int[4],  dx = {0,0,-1,1}, dy = {1,-1,0,0};

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		x = read();
		y = read();
		k = read();
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = read();
			}
		}
		for(int i=0;i<k;i++) {
			int move = read()-1;
			int newX = x+dx[move], newY = y+dy[move];
			// 이동할 수 있을때만 움직임
			if(newX>=0&&newX<n&&newY>=0&&newY<m) {
				if(move == 0) {
					for(int j=3;j>0;j--) {
						int tmp = db[j];
						db[j] = db[j-1];
						db[j-1] = tmp;
					}
					da[0] = db[0];
					da[2] = db[2];
				} else if(move == 1) {
					for(int j=0;j<3;j++) {
						int tmp = db[j];
						db[j] = db[j+1];
						db[j+1] = tmp;
					}
					da[0] = db[0];
					da[2] = db[2];
				} else if(move ==2 ){
					for(int j=3;j>0;j--) {
						int tmp = da[j];
						da[j] = da[j-1];
						da[j-1] = tmp;
					}
					db[0] = da[0];
					db[2] = da[2];
				} else if(move ==3) {
					for(int j=0;j<3;j++) {
						int tmp = da[j];
						da[j] = da[j+1];
						da[j+1] = tmp;
					}
					db[0] = da[0];
					db[2] = da[2];
				}
				if(map[newX][newY]==0) {
					map[newX][newY] = da[2];
				} else {
					da[2]=map[newX][newY];
					db[2]=map[newX][newY];
					map[newX][newY]=0;
				}
				sb.append(da[0]).append("\n");
				x=newX;
				y=newY;
			}
		}
		System.out.println(sb);
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
