// 2146 - 다리만들기  -BFS+DFS - 다시

#include<iostream>
#include<queue>
#include<algorithm>
#include<string.h>
#include<utility>
using namespace std;
int n, a[100][100], i, j, ret = 987654321, vi[100][100], dist[4][2] = { { -1,0 }, { 0,1 }, { 1,0 }, { 0,-1 } }, r;
int ddx, ddy, ct,dx,dy;
queue<pair<int, int> > q;

int bfs2(int cnt) {
	for (int x = 0; x < n; x++) //대륙 번호있는 것들 다 체크
		for (int y = 0; y < n; y++)
			if (a[x][y] == cnt){ vi[x][y] = 1; q.push(make_pair(x, y)); }

	for (r=0; !q.empty();r++) {
		int s = q.size();
		for (int z = 0; z < s; z++) { //현재 갈수있는것들 전부 한발짝식
			dx = q.front().first;
			dy = q.front().second;
			q.pop();
			for (int p = 0; p < 4; p++) { 
				ddx = dx + dist[p][0];
				ddy = dy+ dist[p][1];
				if (ddx >= 0 && ddy >= 0 && ddx < n&&ddy < n) { //범위 안이고
					if (a[ddx][ddy] && a[ddx][ddy] != cnt) return r; // 값이 현재 대륙과 다르면 도착
					else if (!a[ddx][ddy]&&!vi[ddx][ddy]) { vi[ddx][ddy] = 1; q.push(make_pair(ddx, ddy)); } // 바다고, 방문안한거면 나아가기
				}
			}
		}
	}

}
void bfs(int x, int y, int cnt) {
	for (vi[x][y] = 1, a[x][y] = cnt, q.push(make_pair(x, y)); !q.empty(); q.pop()) {
		for (int p = 0; p < 4; p++) {
			dx = q.front().first + dist[p][0];
			dy = q.front().second + dist[p][1];
			if (dx >= 0 && dy >= 0 && dx < n&&dy < n && !vi[dx][dy] && a[dx][dy] == 1) {
				vi[dx][dy] = 1;
				a[dx][dy] = cnt; //대륙 번호 붙혀주기 
				q.push(make_pair(dx, dy));
			}
		}
	}
}
int main() {
	for (cin >> n; i < n; i++)
		for (j = 0; j < n; cin >> a[i][j++]);
	for (ct=2,i = 0; i < n; i++)
		for (j = 0; j < n; j++)
			if (a[i][j] == 1) 
				bfs(i, j, ct++);
	for (i = 2; i < ct; i++) {
		memset(vi, 0, sizeof(vi));
		ret = min(ret, bfs2(i));
		for (; !q.empty(); q.pop());
	}
	cout << ret;
}