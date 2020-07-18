// 16929 - Two dots - dfs 사이클

#include<iostream>
#include<string.h>
using namespace std;
int n, m, i, j, a[4][2] = { { -1,0 }, { 0,1 }, { 1,0 }, { 0,-1 } }, v[50][50], k;
char g[50][50];
bool ch = 1;
int dfs(int x, int y, int cnt) {
	v[x][y] = 1;
	for (int k = 0; k < 4; k++) {
		int b = x + a[k][0], c = y + a[k][1];
		if (b >= 0 && b < n&&c >= 0 && c < m) { //이동 좌표가 거리 내고
			if (!v[b][c] && g[b][c] == g[i][j]) { //방문안했고 색깔이 시작점과 같다면
				if (dfs(b, c, cnt + 1)) // true가 반환돼왔으면 트루 반환
					return 1;
			}
			else if (v[b][c] && g[b][c] == g[i][j] && cnt >= 3 && b == i && c == j) //방문했었고, 색 같고, 4개의점, 좌표가 시작점과 같으면
				return 1; // true 반환
		}
	}
	return 0; // 더이상 갈 곳이 없으면 0 
}
int main() {
	for (cin >> n >> m; i < n; cin >> g[i++]);
	for (i = 0; i < n; i++) {
		for (j = 0; j < m&&ch; j++) {
			if (dfs(i, j, 0)) ch = 0;
			for (k = 0; k < 50; k++)
				memset(v[k], 0, sizeof(v[k]));
		}
	}
	cout << ((ch) ? "No" : "Yes");
}