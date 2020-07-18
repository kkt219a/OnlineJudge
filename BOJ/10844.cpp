//백준 - 10844 - 쉬운 계단 수
//rererererere
#include<iostream>
int n,dp[101][10],i=1,j,m=1000000000;
int main(){
	std::cin>>n;
	dp[1][0]=0; // 1자리수에 0 은없으니 예외처리
	for(;i<10;i++)
		dp[1][i]=1;
	for(i=2;i<=n;i++){
		for(j=0;j<10;j++){
			if(j>0) // j=0일떈 마지막 자리수 1밖에안되니깐
				dp[i][j]+=dp[i-1][j-1]; //
			if(j<9) // j=9일땐 마지막 자리수 8밖에안되니깐.
				dp[i][j]+=dp[i-1][j+1];
			dp[i][j]%=m;
		}
	}
	j=0;
	for(i=0;i<10;i++)
		j=(j+dp[n][i])%m;
	std::cout<<j%m;
}