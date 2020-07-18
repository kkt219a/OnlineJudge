// 11055 - 가장 큰 증가 부분 수열
#include<iostream>
#include<algorithm>
using namespace std;
int n, dp[1001], i = 1, ip[1001], j, k = -1;
int main() {
	for (cin >> n; i <= n; i++) {
		cin >> ip[i];
		dp[i] = ip[i];
		for (j = 1; j < i; j++)
			if (ip[i] > ip[j])
				dp[i] = max(dp[j] + ip[i], dp[i]);
		k = max(dp[i], k);
	}
	cout << k;
}