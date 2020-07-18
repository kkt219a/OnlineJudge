// 10026  - 적록색약  - DFS - 다싱

#include<iostream>
#include<algorithm>
using namespace std;
int n, i, j, dist[4][2] = { {-1,0},{0,1},{1,0},{0,-1} }, ans[2];
bool visited[100][100], visited2[100][100];
char a[100][101];
void dfs(int com, int x, int y, char z) { // 0이면 RGB, 1이면(RG)B
	if (com == 0) { //R G B
		visited[x][y] = 1;
		for (int k = 0; k < 4; k++) {
			int p = dist[k][0] + x, s = dist[k][1] + y;
			if (p >= 0 && p < n&&s >= 0 && s < n&&!visited[p][s] && a[p][s] == z)
				dfs(0, p, s, a[p][s]);
		}
	}
	else { // (RG) B 
		visited2[x][y] = 1;
		for (int k = 0; k < 4; k++) {
			int p = dist[k][0] + x, s = dist[k][1] + y; 
			if (p >= 0 && p < n&&s >= 0 && s < n && !visited2[p][s]) {
				if(a[p][s] == z||((z=='R')&&a[p][s]=='G')|| ((z == 'G') && a[p][s] == 'R'))
					dfs(1, p, s, a[p][s]);
			}
		}
	}
}
int main() {
	for (cin >> n; i < n; cin >> a[i++]);
	for(i=0;i<n;i++)
		for (j = 0; j < n; j++) {
			if (!visited[i][j]) {
				dfs(0, i, j, a[i][j]);
				ans[0]++;
			}
			if (!visited2[i][j]) {
				dfs(1, i, j, a[i][j]);
				ans[1]++;
			}
		}
	cout << ans[0] << " " << ans[1];
}