//백준 - 9095 - 1,2,3더하기
//rerererere
#include<iostream>
using namespace std;

int t,n,dp[11]={0,1,2,4},i=4;
int main(){
	cin>>t;
	for(;i<11;i++)
		dp[i]+=dp[i-1]+dp[i-2]+dp[i-3];
	for(;t>0;t--){
		cin>>n;
		cout<<dp[n]<<"\n";
	}
}