//백준 - 11057 - 오르막 수
#include<iostream>
int dp[1001][10],n,i,j,k,t=10007;
int main(){
	std::cin>>n;
	for(;i<10;i++)
		dp[1][i]=1;
	for(i=2;i<=n;i++)
		for(j=0;j<10;j++)
			for(k=j;k<10;k++)
				dp[i][j]+=dp[i-1][k]%t;
	for(k=0,i=0;i<10;i++)
		k+=dp[n][i]%t;
	std::cout<<k%t;
}