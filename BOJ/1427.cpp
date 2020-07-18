//백준 - 1427 - 소트 인사이드
#include<iostream>
#include<algorithm>
int n,a[10],i,k=1,j;
int main(){
	std::cin>>n;
	for(;n>0;n/=10)
		a[i++]=n%10;
	std::sort(a,a+i);
	for(j=0;j<i;j++,k*=10)
		n+=a[j]*k;
	std::cout<<n;
}