// 1026 보물

#include<iostream>
#include<algorithm>
using namespace std;

int a[50],b[50],n,i,s;

int main(){
	cin>>n;
	for(;i<n;i++)
		cin>>a[i];
	for(i=0;i<n;i++)
		cin>>b[i];
	sort(a,a+n);
	sort(b,b+n);
	for(i=0;i<n;i++)
		s+=b[i]*a[n-i-1];
	cout<<s;
}