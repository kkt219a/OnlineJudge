//알고스팟 - 삼각형 위의 최대경로 - TRIANGLEPATH - rere

#include<iostream>
#include<math.h>
#include<cstring>
using namespace std;
int trng[101][101],dp[101][101],i,j,k,n;
int maxvalue(int a,int b){
	if(a==n-1)
		return trng[a][b];
	int &ret=dp[a][b];
	if(ret!=-1)
		return ret;
	return ret=max(maxvalue(a+1,b),maxvalue(a+1,b+1))+trng[a][b];
}
int main(){
	int t;
	cin>>t;
	for(;i<t;i++){
		memset(dp,-1,sizeof(dp));
		cin>>n;
		for(j=0;j<n;j++)
			for(k=0;k<=j;k++)
				cin>>trng[j][k];
		cout<<maxvalue(0,0)<<"\n";
	}
}