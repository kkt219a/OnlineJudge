//백준 - 11051 - 이항 계수 2
#include<iostream>
using namespace std;
int n, k, dp[1001][1001], i, j;
int main() {
	cin >> n >> k;
	for (; i <= n; i++)
		for (j = 0; j <= i; j++) {
			if (j == 0 || j == i)
				dp[i][j] = 1;
			else
				dp[i][j] = ((dp[i - 1][j]%10007)+ (dp[i - 1][j - 1]%10007))%10007;
		}
	cout << dp[n][k];
}