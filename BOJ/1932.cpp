//백준 - 1932 - 숫자 삼각형
#include<iostream>
int n,dp[501][501],i=1,j;
int main(){
	std::cin>>n;
	for(;i<=n;i++)
		for(j=1;j<=i;j++)
			std::cin>>dp[i][j];
	for(i=1;i<=n;i++)
		for(j=1;j<=i;j++)
			dp[i][j]+=std::max(dp[i-1][j-1],dp[i-1][j]);
	j=-1;
	for(i=1;i<=n;i++)
		if(j<dp[n][i])
			j=dp[n][i];
	std::cout<<j;
}