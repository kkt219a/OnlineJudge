package ps.baekjoon;

// 2022/07/12 2시간
public class P12100 {
	static int n;
	static int[] ret = new int[11];
	public static void main(String[] args) throws Exception {
		n = read();
		int[][] blocks = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				blocks[i][j] = read();
			}
		}
		dfs(0, blocks);
		ret[0] = maxValue(blocks);
		int v = 0;
		for (int i : ret) {
			v = Math.max(v,i);
		}
		System.out.println(v);
	}

	static void dfs(int depth, int[][] blocks) {
		int v = maxValue(blocks);
		if(depth < 10 && v > ret[depth]) {
			for (int i = 0; i < 4; i++) {
				if (i == 0) {
					int[][] temp = top(blocks);
					if(comp(temp,blocks)) {
						dfs(depth + 1, temp);
					}
				} else if (i == 1) {
					int[][] temp = bottom(blocks);
					if(comp(temp,blocks)) {
						dfs(depth + 1, temp);
					}
				} else if (i == 2) {
					int[][] temp = left(blocks);
					if(comp(temp,blocks)) {
						dfs(depth + 1, temp);
					}
				} else {
					int[][] temp = right(blocks);
					if(comp(temp,blocks)) {
						dfs(depth + 1, temp);
					}
				}
			}
		} else {
			calc(v);
		}
	}

	private static int maxValue(int[][] blocks) {
		int v = 0;
		for (int[] block : blocks) {
			for (int b : block) {
				v = Math.max(v,b);
			}
		}
		return v;
	}
	private static void calc(int v) {
		for(int i=10;i>=1;i--, v/=2) {
			ret[i] = Math.max(ret[i],v);
		}
	}

	private static boolean comp(int[][] temp, int[][] blocks) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(temp[i][j] != blocks[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

	private static int[][] top(int[][] block) {
		int[][] tmpBlock = newArr(block);
		for(int j=0;j<n;j++) {
			boolean ok = true;
			for(int i=0;i<n&&ok;i++) {
				if(tmpBlock[i][j] != 0) {
					int k=i+1;
					for(;k<n;k++) {
						if(tmpBlock[k][j] == tmpBlock[i][j]) {
							tmpBlock[i][j] += tmpBlock[k][j];
							tmpBlock[k][j] = 0;
							break;
						} else if(tmpBlock[k][j] != 0) {
							break;
						}
					}
					ok = k != n;
				} else {
					int k=i+1;
					for(;k<n;k++) {
						if(tmpBlock[k][j] != 0) {
							tmpBlock[i][j] = tmpBlock[k][j];
							tmpBlock[k][j] = 0;
							i--;
							break;
						}
					}
					ok = k != n;
				}
			}
		}
		return tmpBlock;
	}

	private static int[][] bottom(int[][] block) {
		int[][] tmpBlock = newArr(block);
		for(int j=0;j<n;j++) {
			boolean ok = true;
			for(int i=n-1;i>=0&&ok;i--) {
				if(tmpBlock[i][j] != 0) {
					int k=i-1;
					for(;k>=0;k--) {
						if(tmpBlock[k][j] == tmpBlock[i][j]) {
							tmpBlock[i][j] += tmpBlock[k][j];
							tmpBlock[k][j] = 0;
							break;
						} else if(tmpBlock[k][j] != 0) {
							break;
						}
					}
					ok = k != -1;
				} else {
					int k=i-1;
					for(;k>=0;k--) {
						if(tmpBlock[k][j] != 0) {
							tmpBlock[i][j] = tmpBlock[k][j];
							tmpBlock[k][j] = 0;
							i++;
							break;
						}
					}
					ok = k != -1;
				}
			}
		}
		return tmpBlock;
	}

	private static int[][] left(int[][] block) {
		int[][] tmpBlock = newArr(block);
		for(int i=0;i<n;i++) {
			boolean ok = true;
			for(int j=0;j<n&&ok;j++) {
				int k=j+1;
				if(tmpBlock[i][j] != 0) {
					for(;k<n;k++) {
						if(tmpBlock[i][k] == tmpBlock[i][j]) {
							tmpBlock[i][j] += tmpBlock[i][k];
							tmpBlock[i][k] = 0;
							break;
						}  else if(tmpBlock[i][k] != 0) {
							break;
						}
					}
				} else {
					for(;k<n;k++) {
						if(tmpBlock[i][k] != 0) {
							tmpBlock[i][j] = tmpBlock[i][k];
							tmpBlock[i][k] = 0;
							j--;
							break;
						}
					}
				}
				ok = k!=n;
			}
		}
		return tmpBlock;
	}

	private static int[][] right(int[][] block) {
		int[][] tmpBlock = newArr(block);
		for(int i=0;i<n;i++) {
			boolean ok = true;
			for(int j=n-1;j>=0&&ok;j--) {
				int k=j-1;
				if(tmpBlock[i][j] != 0) {
					for(;k>=0;k--) {
						if(tmpBlock[i][k] == tmpBlock[i][j]) {
							tmpBlock[i][j] += tmpBlock[i][k];
							tmpBlock[i][k] = 0;
							break;
						}  else if(tmpBlock[i][k] != 0) {
							break;
						}
					}
				} else {
					for(;k>=0;k--) {
						if(tmpBlock[i][k] != 0) {
							tmpBlock[i][j] = tmpBlock[i][k];
							tmpBlock[i][k] = 0;
							j++;
							break;
						}
					}
				}
				ok = k!=-1;
			}
		}
		return tmpBlock;
	}


	private static int[][] newArr(int[][] block) {
		int[][] tmpBlock = new int[n][n];
		for(int i=0;i<n;i++) {
			System.arraycopy(block[i], 0, tmpBlock[i], 0, n);
		}
		return tmpBlock;
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
