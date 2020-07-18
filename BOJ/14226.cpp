// 14226 - 이모티콘 - 2차원방문BFS

#include<iostream>
#include<queue>
using namespace std;
int n, curr, clp, c;
bool vi[1001][1001];
typedef struct { int cur, clip, cnt; }v;
queue<v> q;
int bfs() {
	for (q.push({ 1,0,0 }), vi[1][0] = 1; !q.empty();) {
		curr = q.front().cur;
		clp = q.front().clip;
		c = q.front().cnt;
		q.pop();
		if (n == curr) return c;
		if (curr + clp < 1001) {
			if (!vi[curr][curr]) { vi[curr][curr] = 1; q.push({ curr,curr,c + 1 }); }
			if (clp != 0 && !vi[curr + clp][clp]) { vi[curr + clp][clp] = 1; q.push({ curr + clp,clp,c + 1 }); }
			if (curr != 0 && !vi[curr - 1][clp]) { vi[curr - 1][clp] = 1; q.push({ curr - 1,clp,c + 1 }); }
		}
	}
}
int main() {
	cin >> n;
	cout << bfs();
}