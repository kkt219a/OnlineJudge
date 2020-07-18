// 16947 - 서울 지하철 2호선 - 사이클 DFS+ 최단거리 BFS - 시뮬 오진다 다시!

#include<iostream>
#include<vector>
#include<queue>
using namespace std;
int n, a, b, i = 1,j, v[3001],val[3001]; // v= 0:미방문 1:방문 2:사이클
vector<int> g[3001];
queue<int> q;
int dfs(int x, int y) { // x: 현재, y:이전
	if (v[x] == 1) return x; //방문한거면 이 노드 반환!
	v[x] = 1;  //방문안한거면 
	for (int k = 0,p; k < g[x].size(); k++) {  //얘랑 연결된 노드들 확인
		p = g[x][k];
		if (p == y) continue; // 1칸 차이나는애는 그냥 오기
		int r = dfs(p, x); // 다음 녀석
		if (r == -2) return -2; // -2를 만나는 애들은 단순히 방문되었다고만 남는다! 
		if (r > 0) { //r로 반환된 값은 방문된 녀석이다, 즉 얘를 다시 만나면 사이클 끝남, 계속해서 사이클 끝점을 반환하고 
			v[x] = 2; // 그사이에 있는 애들은 다 사이클
			if (x == r) return -2; // 3에서 시작했는데 끝점이 3을 만났다 그럼 이제부터 -2로 사이클이 아님을 표시
			else return r; // r로 반환
		}
	}
	return -1; // 여기까지 왔다는건 더이상 연결된 노드가 없는거고 얘도 사이클을 못 찾은거다, 방문만 되있는거로 나타나겠지
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (cin >> n; i <= n; cin >> a >> b, g[a].push_back(b), g[b].push_back(a), i++);
	dfs(1, 0);
	for (i = 1; i <= n; i++) {
		if (v[i] == 2) q.push(i); //사이클들을 큐에 넣기
		else val[i] = -1; // 사이클 아닌거 구분위해서!
	}
	for (; !q.empty(); q.pop())
		for(i=q.front(),j=0;j<g[i].size();j++) // 큐에 들어온건 사이클 있는 것들, 얘랑 연결된 점들 확인하기
			if (val[g[i][j]] == -1) { q.push(g[i][j]); val[g[i][j]] = val[i] + 1; } //그 점이 사이클이 아니라면 큐에 넣고 확장 시키고, 그 점은 선택된 점에서 1 증가 
	for (i = 1; i <= n; cout << val[i++] << " ");
}
