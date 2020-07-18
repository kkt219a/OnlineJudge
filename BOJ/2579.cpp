//백준 - 2579 - 계단오르기
//rerererererere
#include<iostream>
using namespace std;
int n,a[301],dp[301],i;
int main(){
	cin>>n;
	for(i=1;i<=n;i++){
		cin>>a[i];
		if(i<3)
			dp[i]=dp[i-1]+a[i];
	}
	for(i=3;i<=n;i++)
		dp[i]=max(a[i]+dp[i-2],a[i]+a[i-1]+dp[i-3]);
	cout<<dp[n];
	
}