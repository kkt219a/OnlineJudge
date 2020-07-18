// 백준 - 1915 - 가장 큰 정사각형
#include<iostream>
#include<algorithm>
using namespace std;
int n,m,i=1,j,dp[1001][1001],k;
char a[1002];
int main() {
    ios_base::sync_with_stdio(false);
	cin.tie(0);
	for(cin>>n>>m;i<=n;i++,a[0]='\0')
		for(cin>>a,j=1;j<=m;k=max(k,dp[i][j++]))
			if(a[j-1]==49)
				dp[i][j]=min(dp[i-1][j],min(dp[i-1][j-1],dp[i][j-1]))+1;
	cout<<k*k;
}