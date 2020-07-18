// 백준 - 줄세우기 - 2605
#include<iostream>
using namespace std;
int n,i,k,a[101],j;
int main(){
	cin>>n;
	for(;i<n;i++){
		cin>>k;
		for(j=1;j<=k;j++)
			a[i-j+1]=a[i-j];
		a[i-k]=i+1;
		
	}
	for(i=0;i<n;i++){
		cout<<a[i];
		if(i!=n-1)
			cout<<" ";
	}
}