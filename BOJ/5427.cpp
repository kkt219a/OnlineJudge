// 5427 - 불 - BFS

#include<iostream>
#include<queue>
using namespace std;
int t, w, h, i, j, time, dist[4][2] = { {0,1},{0,-1},{1,0},{-1,0} }, visited[1000][1000];
char map[1000][1000];
bool tal = 0;
queue<pair<int, int> > q, q2;
void bfs() {
	for (; !tal; time++) { // 탈출할때까지 시간 증가
		for (int k = 0, p = q.size(); k < p; q.pop(), k++) {
			for (int l = 0; l < 4; l++) {
				int a = q.front().first + dist[l][0], b = q.front().second + dist[l][1];
				if (a >= 0 && a < h&&b >= 0 && b < w&&map[a][b] != '#'&&visited[a][b] != 2) { //범위안이고 벽 아니고, 상근이한테 침범가능하니까 불난 자리만 아니면
					q.push({ a,b });
					visited[a][b] = 2;
				}
			}
		}
		for (int k = 0, p = q2.size(); k < p; q2.pop(), k++) {
			for (int l = 0; l < 4; l++) {
				int a = q2.front().first + dist[l][0], b = q2.front().second + dist[l][1];
				if (a >= 0 && a < h&&b >= 0 && b < w&&map[a][b] != '#' && !visited[a][b]) { // 벽이거나 상근이가 이미 방문했거나 불만 아니라면! 
					q2.push({ a,b });
					visited[a][b] = 1;
				}
				else if (a < 0 || a >= h || b < 0 || b >= w) tal = 1; //범위 밖에 나가면 탈출!
			}
		}
		if (q2.empty() && tal != 1) break; //탈출안했는데 상근이가 갈 곳 없으면 그대로 끝
	}
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> t; t--; time = tal = 0) {
		for (cin >> w >> h, i = 0; i < h; i++) {
			cin >> map[i];
			for (j = 0; j < w; j++) {
				if (map[i][j] == '@') { q2.push({ i,j }); visited[i][j] = 1; } //상근이 방문정보 1
				if (map[i][j] == '*') { visited[i][j] = 2; q.push({ i,j }); } // 불 방문정보 2
			}
		}
		bfs();
		if (tal) cout << time << "\n";
		else cout << "IMPOSSIBLE\n";
		for (i = 0; i < h; i++)for (j = 0; j < w; visited[i][j++] = 0);
		for (; !q.empty(); q.pop());
		for (; !q2.empty(); q2.pop());
	}
}