// 10891 - Cactus? Not cactus? - DFS 사이클 응용 - 다시 봐도 모를듯 ㅋㅋ

#include<iostream>
#include<vector>
#include<stdlib.h>
using namespace std;
int n, m, i, vi[100001], a, b;
vector<int> g[100001];
int dfs(int x, int y) {
	if (vi[x] == 1) return x; //완료전 재방문, 즉 사이클, 이 노드값 반환
	if (vi[x] == 2) return 0; //이미 완료된 노드는 더 볼필요x
	int r = 0, s, k = 0;
	vi[x] = 1;
	for (; k < g[x].size(); k++)
		if (g[x][k] != y) { //바로 이전값만 아니면
			s = dfs(g[x][k], x);
			if (s) { //탐색후 값이 있다는건 사이클이 s에 들어가있다
				if (r) { cout << "Not cactus";  exit(0); } //최초 한번으로는 r에 값이 안들어가니, 두번째로 들어오면 선인장x인거로!
				r = s; // 뒤로 전달해주기 위해 r에 저장
			}
		}
	vi[x] = 2;
	if (r == x) return 0; // r이 사이클을 전달해주는앤데 x를 만난거면 지금부터 뒤에있는 애들은 사이클과 관련없는 애들이니 0반환
	return r; // 사이클 없고 단지 끝에 도달한거면 r은 0인체 반환, 사이클이 앞에 있었다면 전달해줘야하니 r에는 값이 있을 것
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> n >> m; i < m; cin >> a >> b, g[a].push_back(b), g[b].push_back(a), i++);
	for (i = 1; i <= n; i++)
		if (!vi[i]) dfs(i, i);
	cout << "Cactus";
}