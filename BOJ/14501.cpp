// 14501 - 퇴사 - DP - 다시

#include<iostream>
#include<algorithm>
using namespace std;
int n, dp[21], a, b, i = 1, ret, c[16], d[16];
int main() {
	for (cin >> n; i <= n; cin >> c[i] >> d[i], i++);
	for (i = 1; i <= n; dp[i + 1] = max(dp[i], dp[i + 1]), i++) // 다음날은 오늘 아무것도 안고른거거나 원래거거나 
		if (i + c[i] <= n + 1)//범위안넘으면
			dp[i + c[i]] = max(dp[i + c[i]], dp[i] + d[i]); // 현재꺼에 가치를 더할지, 원래대로 둘지
	for (i = 1; i <= n + 1; ret = max(ret, dp[i++]));
	cout << ret;
}