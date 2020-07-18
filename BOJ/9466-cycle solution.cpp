// 9466 - 텀프로젝트 - dfs 사이클, 정형화된 방법

#include<iostream>
using namespace std;
int a[100001], n, i, t, cnt;
bool v[100001], c[100001];
void dfs(int nn) {
	v[nn] = 1; //방문
	int nxt = a[nn]; //다음방문할거
	if (!v[nxt]) dfs(nxt); //다음방문안했으면 방문하러
	else if (!c[nxt]) { // 방문했는데 다음거 완료가 안되있다, 즉 사이클이다, 사이클 개수 카운트
		for (int j = nxt; j != nn; cnt++, j = a[j]); 
		cnt++; // 자기자신
	}
	c[nn] = 1; // 얘는 다시 보러 안온다
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> t; t--;cnt=0) {
		for (cin >> n, i = 1; i <= n; cin >> a[i++]);
		for (i = 1; i <= n; i++)
			if (!v[i]) dfs(i);
		cout << n-cnt; // 전체에서 사이클 개수 빼기
		for (i = 1; i <= n; a[i] = c[i] = v[i] = 0, i++);
	}
}