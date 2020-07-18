// 17626 - Four Squares
#include<iostream>
#include<math.h>
#include<algorithm>
using namespace std;
int n, i = 1, j, dp[50001], m;
int main() {
	for (cin >> n; i <= n; dp[i++] = m + 1, m = 999)
		for (j = 1; j <= (int)sqrt(i); m = min(dp[i - j*j], m), j++);
	cout << dp[n];
}