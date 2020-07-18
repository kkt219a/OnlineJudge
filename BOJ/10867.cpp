// 10867 - 중복 빼고 정렬하기

#include<iostream>
#include<algorithm>
using namespace std;
int a,b[100001],i;
int main(){
	cin>>a;
	for(;i<a;i++)
		cin>>b[i];
	sort(b,b+a);
	for(i=1;i<=a;i++)
		if(b[i]!=b[i-1]||i==a)
			cout<<b[i-1]<<" ";
}