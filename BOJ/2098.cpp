// 2098 - 외판원 순회 - DP비트마스크 - 다시
//0번째 도시에서 시작하는거만 보는 이유는 어차피 사이클이 존재하면 0부터0까지 돌아오는 최소값은 1부터 1까지 돌아오는 최소값도 다 같다

#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int n, w[16][16], dp[16][1 << 16], x, y, m = 999999999;
int sol(int cur, int p) { // 현재 도시, 지금까지 방문한 기록들
	if (dp[cur][p] != -1) // 이 도시에서 방문했던 기록이 있다면
		return dp[cur][p];
	if (p == (1 << n) - 1) { // 끝까지 방문하면
		if (w[cur][0] != 0) // 현재 도시에서 처음으로 돌아갈 수 있는가?
			return w[cur][0];
	}
	dp[cur][p] = m; // 값은 맥스로 잡고
	for (int i = 0;i<n;i++)
		if(w[cur][i]!=0&&((p&(1<<i))==0)) // 길이 있고 방문하지 않았다면
			dp[cur][p]=min(dp[cur][p],sol(i,(p|(1<<i)))+w[cur][i]); // 이 도시에서 이 루트 기록을  지정
	return dp[cur][p]; // 최종 반환
}
int main() {
	memset(dp, -1, sizeof(dp));
	for (cin >> n,x=0;x<n;x++)
		for (y = 0; y < n; cin >> w[x][y++]);
	cout << sol(0, 1);
}