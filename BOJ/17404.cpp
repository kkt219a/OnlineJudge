// 17404 - RGB거리2

#include<iostream>
#include<algorithm>
using namespace std;
int dp[1001][3],n,i=1,j,a[1001][3],m=99999999;
int main(){
	for(cin>>n;i<=n;cin>>a[i][0]>>a[i][1]>>a[i][2],i++);
	for(j=0;j<3;j++){
		for(i=0;i<3;i++){
			if (i==j) dp[1][i]=a[1][j];
			else dp[1][i]=1001;
		}
		for(i=2;i<=n;i++){
			dp[i][0]=a[i][0]+min(dp[i-1][1],dp[i-1][2]);
			dp[i][1]=a[i][1]+min(dp[i-1][0],dp[i-1][2]);
			dp[i][2]=a[i][2]+min(dp[i-1][0],dp[i-1][1]);
		}
		for(i=0;i<3;i++){
			if (i == j) continue;
			else m=min(m,dp[n][i]);
		}	
	}
	cout<<m;
}