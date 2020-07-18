//1309 - 동물원

#include<iostream>
using namespace std;
int dp[100001][3]={{0},{1,1,1},},n,i=2,k=9901;
int main(){
	for(cin>>n;i<=n;i++){
		dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%k;
		dp[i][1]=(dp[i-1][0]+dp[i-1][2])%k;
		dp[i][2]=(dp[i-1][0]+dp[i-1][1])%k;
	}
	cout<<(dp[n][0]+dp[n][1]+dp[n][2])%k;
}