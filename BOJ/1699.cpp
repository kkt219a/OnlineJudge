//1699 - 제곱수의 합

#include<iostream>
#include<algorithm>
#include<math.h>
using namespace std;
int dp[100001] = { 0,1, }, n, i = 2, j;
int main() {
	for (cin >> n; i <= n;i++)
		for (dp[i] = 99999,j = 1; j <= (int)sqrt(i); dp[i] = min(dp[i - j * j] + 1,dp[i]), j++);
	cout << dp[n];
}