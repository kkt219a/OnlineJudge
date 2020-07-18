// 11053 - 가장 긴 증가하는 부분 수열
#include<iostream>
#include<algorithm>
using namespace std;
int n, dp[1001], i=1, ip[1001], j;
int main() {
	for (cin >> n; i <= n; cin >> ip[i], i++);
	for (i = 1; i <= n; i++) {
		dp[i] = 1;
		for (j = 1; j < i; j++)
			if (ip[i] > ip[j])
				dp[i] = max(dp[j] + 1, dp[i]);
	}
	for (i = 1,j=-1; i <= n; i++)
		j = max(dp[i], j);
	cout << j;
}