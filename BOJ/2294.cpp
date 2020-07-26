//2294 - 동전 2 - DP
#include<iostream>
#include<algorithm>
using namespace std;
int n, k, i=1, a[100], j, dp[10001];
int main() {
	for (; i < 10001; dp[i++] = 10001); //최대 값보다 크게 설정
	for (i=0,cin >> n >> k; i < n;i++) // 1개씩 입력하면서
		// dp[j - a[i]]+1: j - a[i]에서 coin[i]를 더해 만드는 동전의 개수
		for (cin >> a[i],j = a[i]; j <= k; dp[j] = min(dp[j], dp[j - a[i]] + 1), j++);
	cout << ((dp[k] == 10001) ? -1 : dp[k]);
}
