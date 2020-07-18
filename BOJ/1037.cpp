//백준 - 1037 - 약수
#include<iostream>
#include<algorithm>
int n,a[50],i,b;
int main(){
	std::cin>>n;
	for(;i<n;i++)
		std::cin>>a[i];
	std::sort(a,a+i);
	b=a[0]*a[i-1];
	std::cout<<b;
}