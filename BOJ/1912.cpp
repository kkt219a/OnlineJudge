//백준 - 1912 - 연속합
//연속합원리 꼭꼭 rererererererere!
#include<iostream>
using namespace std;
int d[100001],n,i=1,m=-1001;
int main(){
	cin>>n;
	for(;i<=n;i++){
		cin>>d[i];
		d[i]=max(d[i],d[i]+d[i-1]); //이전의 합과 현재 수를 더한게 더 이득이면 그걸넣고, 이득이아니면 현재수부터 다시시작.
		m=max(m,d[i]);
	}
	cout<<m;
}