// 백준 - 15686 - 치킨배달 - DFS 순열 

#include<iostream>
#include<utility>
#include<vector>
#include<math.h>
#include<algorithm>
using namespace std;
int n, m, i, j, k, s, rs, vi[14], ans=9999, tmp, mi, tmp2;
vector<pair<int, int> > h, c, v;
void dfs(int a, int b) { // a: v의 개수 b: 
	if (a == m) { // v의 개수가 5개가 되면
		for (tmp2=i = 0; i < h.size();tmp2+=mi, i++) // tmp2에 최소거리를 다 합하기
			for (mi = 9999, j = 0; j < a; j++) // v에 들어있는 치킨집과 모든 집들과 비교
				mi=min(mi, abs(h[i].first - v[j].first) + abs(h[i].second - v[j].second));
		ans = min(ans, tmp2); // 이 값의 최소 값 
	}
	else // 아니면
		for (int t = b; t < c.size(); t++) { // 순열, 무조건 현재의 다음 것을 방문해야한다.
			if (!vi[t]) { // 방문 안했으면 걔를 포함
				vi[t] = 1;
				v.push_back(c[t]);
				dfs(a + 1, t + 1); // 지금 있는 수의 다음 수, 그리고 한개를 추가함을 알려줌
				vi[t] = 0; // 방문 체크 해제
				v.pop_back(); // 그리고 지우면 그 다음 친구가 방문할 수 있다.
			}
		}
}
int main() {
	for (cin >> n >> m; i < n; i++)
		for (j = 0; j < n; j++) {
			cin >> k;
			if (k == 1) h.push_back(make_pair(i, j));
			if (k == 2) c.push_back(make_pair(i, j));
		}
	dfs(0,0);
	cout << ans;
}