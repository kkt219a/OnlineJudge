// 2750 - 수 정렬하기
#include<iostream>
#include<stdlib.h>
#include<algorithm>

using namespace std;

int main(){
	int n,*a;
	cin>>n;
	a=(int*)malloc(sizeof(int)*n);
	for(int i=0;i<n;i++)
		cin>>a[i];
	sort(a,a+n);
	for(int i=0;i<n;i++)
		cout<<a[i]<<"\n";
	
}