//2206 -  벽 부수고 이동하기 - BFS

#include<iostream>
#include<queue>
using namespace std;
char map[1000][1000];
int n, m, i, dist[4][2] = { {0,-1},{1,0},{0,1},{-1,0} }, a, b, c, d, e;
int visited[1000][1000][2];
struct poi {
	int x, y, fort;
};
queue<poi> q;
int bfs() {
	q.push({ 0,0,1 });
	visited[0][0][1] = 1;
	while (!q.empty()) {
		c = q.front().x;
		d = q.front().y;
		e = q.front().fort;
		if (q.front().x == n - 1 && q.front().y == m - 1) //목적지 도달시 출력
			return visited[c][d][e];
		for (int i = 0; i < 4; i++) { // 상하좌우
			a = c+ dist[i][0];
			b = d + dist[i][1];
			if (a >= 0 && a < n&&b >= 0 && b < m) { //  범위안에 있다면
				if (map[a][b] == '1' && e) { // 못가는데 벽 뚫을 수 있다면
					visited[a][b][0] = visited[c][d][1] + 1; // 지금꺼 뚫고 기회 0으로, 
					q.push({ a,b,0 }); // 기회는 없애고 넣기
				}
				else if (map[a][b] == '0'&&visited[a][b][e]==0) { // 갈수 있고, 방문한 적 없다면
					visited[a][b][e] = visited[c][d][e] + 1; //방문 표시
					q.push({ a,b,e }); // 큐에 넣기
				}
			}
		}
		q.pop();
	}
	return -1;
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> n >> m; i < n; cin >> map[i++]);
	cout<<bfs();
}