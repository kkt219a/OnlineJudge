//백준 - 1453 - 피시방 알바
#include<iostream>
int t,n[100],i,p,dp[101];
int main(){
	std::cin>>t;
	for(i=0;i<t;i++){
		std::cin>>n[i];
		dp[n[i]]++;
	}
	for(i=1;i<101;i++)
		if(dp[i]>1)
			p+=dp[i]-1;
	std::cout<<p;
}