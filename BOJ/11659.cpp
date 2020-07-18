//백준 - 11659 - 구간 합 구하기 4
#include<iostream>
using namespace std;
int dp[100001],n,m,i=1,j,k;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for(cin>>n>>m;i<=n;cin>>dp[i],dp[i]+=dp[i - 1],i++);
	for(i=1;i<=m;i++){
		cin>>j>>k;
		n=dp[k];
		if (j != 0) n-=dp[j-1];
		cout<<n<<"\n";
	}
}