// 12865 - 평범한 배낭

#include<iostream>
#include<algorithm>
using namespace std;
int n, k, w[101], v[101], dp[100001], i=1, j;
int main() {
	for (cin >> n >> k; i <= n; cin >> w[i] >> v[i], i++);
	for (i = 1; i <= n; i++)
		for (j = k; j-w[i] >= 0; j--)
				dp[j] = max(dp[j], dp[j - w[i]] + v[i]);
	cout << dp[k];
}