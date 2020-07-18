//백준 - 11004 - k번째수
#include<iostream>
#include<algorithm>
#include<stdlib.h>
using namespace std;
int n,k,*a,i;
int main(){
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin>>n>>k;
	a=(int*)malloc(sizeof(int)*n);
	for(;i<n;i++)
		std::cin>>a[i];
	sort(a,a+n);
	cout<<a[k-1];
}