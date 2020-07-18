// 1110 - 더하기 사이클

#include<iostream>
int n,m,c;
int main(){
	std::cin>>n;
	m=n;
	do{
		n=n%10*10+(n/10+n%10)%10;
		c++;
	}while(n!=m);
	std::cout<<c;
}