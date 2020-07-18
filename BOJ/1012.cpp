// 1012-유기농배추BFS
#include<iostream>
#include<queue>
using namespace std;
int t, a, b, k, i, j, r[50][50], cnt, x, y;

int bfs() {
	queue<pair<int,int>> q;
	i = 0;
	for (; i < a; i++) {
		for (j=0; j < b; j++) {
			if (r[i][j] == 1) {
				q.push(make_pair(i, j));
				r[i][j] = 0;
				while (!q.empty()) {
					x = q.front().first;
					y = q.front().second;
					q.pop();
					if (y != 0 && r[x][y-1] == 1) {
						q.push(make_pair(x, y - 1));
						r[x][y - 1] = 0;
					}
					if (x != 0 && r[x - 1][y] == 1) {
						q.push(make_pair(x - 1, y));
						r[x - 1][y] = 0;
					}
					if (y != (b - 1) && r[x][y + 1] == 1) {
						q.push(make_pair(x, y + 1));
						r[x][y + 1] = 0;
					}
					if (x != (a - 1) && r[x + 1][y] == 1) {
						q.push(make_pair(x + 1, y));
						r[x + 1][y] = 0;
					}
				}//while
				cnt++;
			} // if
		} // for j 
	} // for i
	return cnt;
}// bfs
int main() {
	for (cin >> t; t--;cnt=0) {
		for (cin >> a >> b >> k; k--;) {
			cin >> i >> j;
			r[i][j] = 1;
		}
		printf("%d\n",bfs());
	}
}