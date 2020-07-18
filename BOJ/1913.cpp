////백준 - 1913 - 달팽이
#include<iostream>
using namespace std;
int n[1001][1001],t,a=1,b,i,j,k;
int main(){
	cin>>t>>j;
	k=t*t;
	for(b=t;a<=b;a++,b--){
		for(i=a;i<=b;i++,k--)
			n[i][a]=k;
		for(i=a+1;i<=b;i++,k--)
			n[b][i]=k;
		for(i=b-1;i>=a;i--,k--)
			n[i][b]=k;
		for(i=b-1;i>a;i--,k--)
			n[a][i]=k;
	}
	
	for(a=1;a<=t;a++){
		for(b=1;b<=t;b++){
			if(n[a][b]==j){
				i=a;
				k=b;
			}
			cout<<n[a][b]<<" ";
		}
		cout<<"\n";
	}
	cout<<i<<" "<<k;
}