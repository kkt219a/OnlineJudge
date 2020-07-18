// 13398 - 연솝합 2

#include<iostream>
#include<algorithm>
using namespace std;
int dp[100001][2], a[100001], n, i = 1, m = -1001;
int main() {
	for (cin>>n; i <= n; i++) {
		cin >> a[i];
        if(i==1){
            dp[i][1]=dp[i][0]=a[i];
            continue;
        }
		dp[i][0] = max(dp[i - 1][0] + a[i], a[i]);
		dp[i][1] = max(dp[i - 1][1] + a[i], dp[i - 1][0]);
		m = max(m, max(dp[i][1], dp[i][0]));
	}
	if (n == 1) m = a[1];
	cout << m;
}