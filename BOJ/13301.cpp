//백준 - 13301 - 타일 장식물
#include<iostream>
int n,i;
long long a[80];
int main(){
	std::cin>>n;
	a[0]=1;a[1]=1;
	for(;i<n-2;i++)
		a[i+2]=a[i]+a[i+1];
	std::cout<<4*a[n-1]+2*a[n-2];
}