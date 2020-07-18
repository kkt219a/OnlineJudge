// 11722 - 가장 긴 감소하는 부분 수열

#include<iostream>
#include<algorithm>
using namespace std;
int n, dp[1001], i = 1, ip[1001], j, k = -1;
int main() {
	for (cin>>n; i <= n; i++) {
		cin >> ip[i];
		dp[i] = 1;
		for (j = 1; j < i; j++)
			if (ip[i] < ip[j])
				dp[i] = max(dp[j] + 1, dp[i]);
		k = max(dp[i], k);
	}
	cout << k;
}