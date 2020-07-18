//알고스팟 - 외발뛰기 - JUMPGAME -rere
#include<iostream>
#include<cstring>
using namespace std;
int t,n,i,j,k,hi[101][101],dp[101][101];
int cal(int a,int b){
	if(a>=n||b>=n)
		return 0;
	if(a==n-1&&b==n-1)
		return 1;
	int &ret=dp[a][b];
	if(ret!=-1)
		return ret;
	return ret=cal(a+hi[a][b],b)||cal(a,b+hi[a][b]);
}

int main(){
	cin>>t;
	for(;i<t;i++){
		cin>>n;
		memset(dp,-1,sizeof(dp));
		for(j=0;j<n;j++)
			for(k=0;k<n;k++)
				cin>>hi[j][k];
		if(cal(0,0))
			cout<<"YES";
		else
			cout<<"NO";
	}
}