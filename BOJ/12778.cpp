//백준 - 12778 - CTP공국으로 이민 가자
#include<iostream>
using namespace std;
char a[500],b;
int n,t,i,c[500];
int main(){
	cin>>t;
	for(;t>0;t--){
		cin>>n>>b;
		if(b=='C'){
			for(i=0;i<n;i++)
				cin>>a[i];
			for(i=0;i<n;i++)
				printf("%d ",a[i]-64);
		}
		
		else{
			for(i=0;i<n;i++)
				cin>>c[i];
			for(i=0;i<n;i++)
				printf("%c ",c[i]+64);
		}
		cout<<"\n";
	}
}