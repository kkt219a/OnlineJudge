// 13023 - ABCDE- DFS

#include<iostream>
#include<vector>
#include<string.h>
#include<stdlib.h>
using namespace std;
vector<int> f[2000];
int n, m, i, a, b, v[2000];
void e(int s, int d) {
	if (d == 4) {cout<<"1";exit(0);}
	v[s]=1;
	for (int j = 0; j<f[s].size(); j++) {
		if (v[f[s][j]]) continue;
		v[f[s][j]] = 1;
		e(f[s][j], d + 1);
		v[f[s][j]] = 0;
	}
	v[s]=0;
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> n >> m; i < m; i++) {
		cin >> a >> b;
		f[a].push_back(b);
		f[b].push_back(a);
	}
	for (i = 0;i<n;e(i,0),memset(v, 0, sizeof(v)),i++);
	cout << "0";
}