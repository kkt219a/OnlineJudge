//5557 - 1학년  - dp+조합

#include<iostream>
using namespace std;
long long n, arr[100], i, dp[100][21], j; // dp[i][j] = i번째까지 j를 만들 수 있는 경우의 수
int main() {
	for (cin >> n; i < n; cin >> arr[i++]);
	for (dp[0][arr[0]]++, i = 1; i < n - 1; i++) // 0번째수까지 arr[0]를 만들 수 있는 방법은 1가지, n-2번째 수 까지
		for (j = 0; j < 21; j++) {
			if (dp[i - 1][j]) { //  이전의 수로 j를 만들수 있었다면
				//이전의 수에 현재 수를 더하거나 뺀게 범위 안에 들어오면
				if (j + arr[i] < 21) dp[i][j + arr[i]] += dp[i - 1][j]; //현재 위치에 현재 수를 더한 결과는 이전의 수까지 경우의 수가 더해진다
				if (j - arr[i] >=0) dp[i][j - arr[i]] += dp[i - 1][j]; // ''
			}
		}
	cout << dp[n - 2][arr[n - 1]]; // n-2번째에서 마지막 수를 만들 수 있는 경우의 수를 출력
}