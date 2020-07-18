//백준 - 5054 - 주차의 신
#include<iostream>
#include<algorithm>
using namespace std;
int t,n,a[20],i,s;
int main(){
	cin>>t;
	for(;t>0;t--){
		cin>>n;
		for(i=0;i<n;i++)
			cin>>a[i];
		sort(a,a+n);
		s=a[n-1]-a[0];
		cout<<2*s<<"\n";
	}
}