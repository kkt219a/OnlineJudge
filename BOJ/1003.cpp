//백준 - 1003 - 피보나치 (dp)
#include<iostream>
int dp[41][2],t,n,i;
int main(){
	std::cin>>t;
	for(;i<2;i++)
		dp[i][i]=1;
	for(;i<41;i++){
		dp[i][0]=dp[i-2][0]+dp[i-1][0];
		dp[i][1]=dp[i-2][1]+dp[i-1][1];
	}
	for(;t>0;t--){
		std::cin>>n;
		std::cout<<dp[n][0]<<" "<<dp[n][1]<<"\n";
	}
}