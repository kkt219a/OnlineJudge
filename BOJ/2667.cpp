// 2667-단지번호 붙히기 - dfs/bfs 
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;
int a, i, j, k, l, ct;
vector<int> v;
queue<pair<int,int> > q;
char b[25][25];
void bfs() { 
	for (i = 0; i < a; i++) {

		for (j = 0; j < a; j++) {
			if (b[i][j] =='1') {
				q.push(make_pair(i,j));
				b[i][j] = 0;
				while (!q.empty()) {
					k = q.front().first;
					l = q.front().second;
					q.pop();
					if (k != 0 && b[k - 1][l] == 49) {
						b[k - 1][l] = 0;
						q.push(make_pair(k-1, l));
						ct++;
					}
					if (l != 0 && b[k][l-1] ==49) {
						b[k][l-1] = 0;
						q.push(make_pair(k, l-1));
						ct++;
					}
					if (k != a-1 && b[k+1][l] ==49) {
						b[k + 1][l] = 0;
						q.push(make_pair(k + 1, l));
						ct++;
					}
					if (l != a-1 && b[k][l+1] ==49) {
						b[k][l+1] = 0;
						q.push(make_pair(k, l+1));
						ct++;
					}
				}
				v.push_back(++ct);
				ct = 0;
			}
		}
	}
}
int main() {
	cin >> a;
	for (; i < a; i++)
		for (j = 0; j < a; j++)
			cin >> b[i][j];
	bfs();
	sort(v.begin(), v.end());
	cout << v.size() << "\n";
	for (i = 0; i < v.size(); i++)
		cout << v[i] << "\n";
}