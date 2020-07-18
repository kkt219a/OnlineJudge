// 6593 - 상범빌딩 - BFS

#include<iostream>
#include<queue>
using namespace std;
int L, R, C, i, j, k, time, a, b, c;
int visited[30][30][30];
int dist[6][3] = {{ -1,0,0 }, { 0,1,0 }, { 1,0,0 }, { 0,-1,0 }, { 0,0,1 }, { 0,0,-1 }}; //x,y,z순
char map[31][31][31]; //z,x,y 순
bool po = 0;
typedef struct { int x, y, z; }Top;
queue<Top> q;
void bfs() {
	for (; !po; time++) {
		for (i = 0, j = q.size(); i < j;q.pop(), i++) {
			for (k = 0; k < 6; k++) {
				a = q.front().x + dist[k][0];
				b = q.front().y + dist[k][1];
				c = q.front().z + dist[k][2];
				if (a >= 0 && a < R&&b >= 0 && b < C&&c >= 0 && c < L&&!visited[c][a][b]) { //범위 안, 방문 안했으면
					if (map[c][a][b] == 'E') po = 1;
					else if (map[c][a][b] == '.') q.push({ a,b,c });
					visited[c][a][b] = 1;
				}
			}
		}
		if (q.empty()&&po!=1) break;
	}
}
int main() {
	for (;;time=po=0) {
		cin >> L >> R >> C;
		if (!L && !R && !C) break;
		for (i=0; i < L; i++)
			for (j = 0; j < R; j++)
				for (cin >> map[i][j], k = 0; k < C; k++)
					if (map[i][j][k] == 'S') { visited[i][j][k] = 1; q.push({ j,k,i }); }
		bfs();
		if (po) cout << "Escaped in "<<time<<" minute(s).\n";
		else cout << "Trapped!\n";
		for (i = 0; i < L; i++)for (j = 0; j < R; j++) for (k = 0; k < C; visited[i][j][k++] = 0);
		for (; !q.empty(); q.pop());
	}
}