// GRADUATION - 졸업학기 - 비트마스크+DP

#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int c, n, k, m, l, R, inp, inf = 987654321, ans, i, j;
int a[12],b[10],dp[10][1<<12]; // 각 과목별로 선수과목들이 12자리로 되어있겠지 , 개설 과목 정보들
int bitc(int k) { if (k == 0)return 0; return k % 2 + bitc(k / 2); } // 1인 과목 개수 반환
int solve(int sem, int taken) { // 학기, 지금까지 들은 과목
	if (bitc(taken) >= k) return 0; // 이미 들을 과목 다 들었으면
	if (sem == m) return inf; // 학기가 다 차서 졸업 못하면
	if (dp[sem][taken] != -1)
		return dp[sem][taken];
	int mina = inf; // 최대 값으로 지정
	int cantake = (~taken&b[sem]); // 이번 학기에 들을 과목중 아직 듣지 않은 것
	for (int i = 0; i < n; i++) // 선수과목 안 들은거 걸러내기
		if (cantake&(1 << i) && ((a[i] & taken) != a[i])) // 그 과목이 일단 있고, taken에서 수강했는지 확인, 안들었으면 얘는 제외
			cantake &= ~(1 << i); //여기에는 이번 학기에 들을 과목중 정말 들을 수 있는 것들만 남아있다. 
	for (int i = cantake; i > 0;i=(cantake&i-1)) { // 들을 과목중 한 학기 듣는거 초과 안 하는 건 일단 다 들은거로 하고, 다음학기에 이걸 들은거로 한 상태로 넘긴다
		if (bitc(i) > l) continue; // 한 학기에 들을 수 있는 과목을 초과할 시
		mina = min(mina, solve(sem + 1, i | taken) + 1);
	}
	mina = min(mina, solve(sem + 1, taken)); // 만약 아무것도 안듣는 경우도 봐야하니 다음 학기로 바로 넘기기
	return dp[sem][taken]=mina; // 특정 과목까지 들은 이번학기에 대한 정보는 dp에 담아두기
}
int main() {
	for (cin >> c; c--;) {
		memset(a, 0, sizeof(a));
		memset(b, 0, sizeof(b));
		memset(dp, -1, sizeof(dp));
		for (cin >> n >> k >> m >> l, i = 0; i < n; i++) { //전공과목 수 n, 들어야할 과목 수 k, 학기 수 m, 한 학기 최대 듣는 과목 수 L
			cin >> R; // 선수 과목의 수
			for (j = 0; j < R; j++) {// i번 과목의 선수과목들을 저장
				cin >> inp;
				a[i] |= (1 << inp);
			}
		}
		for (i = 0; i < m; i++) { // 각 학기의 정보 
			cin >> R; // 개설 과목의 수
			for (j = 0; j < R; j++) { // 학기별 개설되는 과목들의 정보를 저장
				cin >> inp;
				b[i] |= (1 << inp); 
			}
		}
		ans = solve(0, 0);
		if (ans == inf) // ans가 inf면 학기가 다 차서 졸업을 못한 경우
			cout << "IMPOSSIBLE"<<"\n";
		else
			cout << ans << "\n";
	}
}