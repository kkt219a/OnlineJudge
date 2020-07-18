// 9466 - 텀프로젝트 - dfs 사이클, 내 방식 

#include<iostream>
#include<vector>
using namespace std;
int t, n, a[100001], i, cnt, ch, visited[100001], h;
int dfs(int nn, int origin) {
	if (visited[nn]==0) { // 얘방문 안했으면
		visited[nn] = 1;
		int f = dfs(a[nn], origin); // f가 -1이 아니면 nn값을 반환 하겠지, 그리고 사이클들 다 빼고나면 0을 반환하겠지
		if (f == nn) { f = 0; visited[nn] = 3;}
		else if (visited[f] > 1) { f = 0; visited[nn] = 2; }
		else if (f == 0) {
			//cout << "kk<";
			visited[nn] = 2;
		}// 사이클 있는애들은 1, 안본애들은 0, 없는애들은 2니까 2면 아예 안들어오면 됨 
		else visited[nn] = 3; //사이클이 된다는 표시
		return f;
	}
	else if (nn != origin) //방문했던건데 origin과 다르다? 얘는 틀렸어,근데 사이클이 있을수도!
		return nn;
	else //사이클이 발생된 경우가 -1이다.
		return -1;
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> t; t--;cnt=0) {
		for (cin >> n, i = 1; i <= n; cin >> a[i++]);
		for (i = 1; i <= n; i++) { //하나하나 봐가면서
			if (visited[i]==0) { // 얘가 방문안했으면
				ch=dfs(i, i);
				if (ch>=0) cnt++; //사이클이 발생하지 않았을때
			}
			else if(visited[i]==2)  cnt++; //사이클이 없던 애들로 분류된 애들
			for (h = 1; h <= n; cout << visited[h++] << " ");
			cout << "\n";
		}
		cout << cnt << "\n";
		for (i = 1; i <= n; visited[i++] = 0);
	}
}