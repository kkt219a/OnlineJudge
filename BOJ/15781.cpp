//백준 - 15781 - 헬멧과 조끼
#include<iostream>
using namespace std;
int a,b,c,d,m,n,i;
int main(){
	cin>>c>>d;
	for(;i<c;i++){
		cin>>a;
		m=max(m,a);
	}
	for(i=0;i<d;i++){
		cin>>b;
		n=max(n,b);
	}
	cout<<m+n;
}