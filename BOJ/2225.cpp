// 2225 - 합분해
#include<iostream>
using namespace std;
int dp[201][201],i=1,j,l;
int main(){
	for(;i<201;i++)
		for(j=1;j<201;dp[i][j]++,j++)
			for(l=1;l<=i;dp[i][j]=(dp[i][j]+dp[l][j-1])%1000000000,l++);
	cin>>i>>j;
	cout<<dp[i][j];
}