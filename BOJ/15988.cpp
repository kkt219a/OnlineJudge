//15988 - 1, 2, 3 더하기 3

#include<iostream>
using namespace std;
long long dp[1000001] = { 0,1,2,4, }, i = 4, n, t;
int main() {
	for (; i < 1000001; dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1])%1000000009, i++);
	for (cin >> t; t--; cin >> n, cout << dp[n] << "\n");
}