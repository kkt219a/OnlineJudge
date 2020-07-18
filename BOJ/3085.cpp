// 3085 - 사탕 게임

#include<iostream>
#include<algorithm>
using namespace std;
int n,i=1,j,k,ct,m;
char a[52][52];
void f(int z){
	for(ct=1,k=1;k<n;m=max(ct,m),k++){
		if(z==0){
			if(a[i][k]==a[i][k+1])ct++;
			else ct=1;
		}
		else{
			if(a[k][i]==a[k+1][i])ct++;
			else ct=1;
		}
	}
}
int main(){
	for(cin>>n;i<=n;i++)
		for(j=1;j<=n;cin>>a[i][j++]);
	for(i=1;i<=n;i++){
		for(j=1;j<=n;f(0),f(1),j++){
			swap(a[i][j],a[i-1][j]);
			f(0);
			swap(a[i][j],a[i-1][j]);
			swap(a[i][j],a[i+1][j]);
			f(0);
			swap(a[i][j],a[i+1][j]);
			swap(a[j][i],a[j][i-1]);
			f(1);
			swap(a[j][i],a[j][i-1]);
			swap(a[j][i],a[j][i+1]);
			f(1);
			swap(a[j][i],a[j][i+1]);
		}
	}
	cout<<m;
}