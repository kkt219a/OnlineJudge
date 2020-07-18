//백준 - 약수 구하기 - 2501
#include<iostream>
using namespace std;

int n,k,i=1,j,a[10000];
int main(){
	cin>>n>>k;
	for(;i<=n;i++)
		if(n%i==0)
			a[j++]=i;
	cout<<a[k-1];
}
