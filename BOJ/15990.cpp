//15990 - 1, 2, 3 더하기 5

#include<iostream>
using namespace std;
long long dp[100001][3] = { {0,0,0}, {1,0,0},{0,1,0},{1,1,1}, }, n, i = 4, t;
int main() {
	for (; i < 100001; i++) {
		dp[i][0] = (dp[i - 1][1] + dp[i - 1][2])%1000000009;
		dp[i][1] = (dp[i - 2][0] + dp[i - 2][2])%1000000009;
		dp[i][2] = (dp[i - 3][0] + dp[i - 3][1])%1000000009;
	}
	for (cin >> t; t--; cin >> n, cout << (dp[n][0] + dp[n][1] + dp[n][2])% 1000000009 <<"\n");
}