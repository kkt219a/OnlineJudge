// 1766 - 문제집 - 최소힙과 위상정렬 bfs

#include<iostream>
#include<queue>
#include<vector>
using namespace std;
int n, m, i, vi[32001], a, b, j;
priority_queue<int, vector<int>, greater<int> > q;
vector<int> v[32001];
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (cin >> n >> m; i < m; cin >> a >> b, v[a].push_back(b), vi[b]++, i++); // vi[b]는 선행으로 해결되어야 할 개수를 저장
	for (i = 1; i <= n; i++) if (!vi[i]) q.push(i);  //선행으로 해결되야 할 것들이 없는 것들!
	for (; !q.empty();) {
		for (i = 0, j = q.top(), cout << j << " ", q.pop(); i < v[j].size();i++) { //작은 문제 먼저 풀라했으니까 최소 힙으로!, 이 문제를 풀었다고
			//가정하고, 해당하는 정점들의 선행개수를 1개씩 줄이고 0개면 얘도 바로 풀 수 있으니까 풀어주기!!
			vi[v[j][i]]--;
			if((vi[v[j][i]])==0)
				q.push(v[j][i]);
		}
	}
}