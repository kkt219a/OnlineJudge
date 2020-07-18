// 3055 - 탈출

#include<iostream>
#include<queue>
using namespace std;
char e;
int n, m, i = 1, j, v[52][52], k, l, o,u[5][2]={{0,0},{0,1},{1,0},{0,-1},{-1,0}}, t;
queue<pair<int, int> > q1,q2;
bool f;
void bfs() {
	for (;!f;t++) {
		for (i=q1.size(),j=0;j<i;q1.pop(),j++)
			for (o = 0; o < 5; o++){
				k = q1.front().first + u[o][0];
				l = q1.front().second + u[o][1];
				if (k > n || l > m||k<1||l<1) continue;
				else if (v[k][l] < 2) {
					v[k][l] = 2;
					q1.push(make_pair(k, l));
				}
			}
		for (i=q2.size(),j=0;j<i;j++) {
			for (o = 0; o < 5; o++) {
				k = q2.front().first + u[o][0];
				l = q2.front().second + u[o][1];
				if (k > n || l > m||k<1||l<1) continue;
				else if (v[k][l] == 4) f = 1;
				else if (v[k][l] < 1) {
					v[k][l] = 1;
					q2.push(make_pair(k, l));
				}
			}
			if(f) break;
            q2.pop();
		}
		if(q2.empty()) break;
	}
}
int main() {
	for (cin >> n >> m; i <= n; i++)
		for (j = 1; j <= m; j++) {
			cin >> e;
			if (e == 83) q2.push(make_pair(i, j));
			else if (e == 42) q1.push(make_pair(i, j));
            else if (e == 68) v[i][j] = 4;
			else if (e == 88) v[i][j] = 3;
		}
	bfs();
	if (f)
		cout << t;
	else
		cout << "KAKTUS";
}