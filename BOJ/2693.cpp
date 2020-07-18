//백준 - 2693 - n번째 큰수
#include<iostream>
#include<algorithm>
using namespace std;
int t,n[10],i;
int main(){
	cin>>t;
	for(;t>0;t--){
		for(i=0;i<10;i++)
			cin>>n[i];
		sort(n,n+10);
		cout<<n[7]<<"\n";
	}
}