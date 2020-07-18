//백준 - 10872 - 팩토리얼(2)
#include<iostream>
int n,i=1,k;
int main(){
	std::cin>>n;
	k=n;
	if(n==0)
		n=1;
	for(;i<k;i++)
		n*=i;
	std::cout<<n;	
}