//백준 - 10430 - 나머지
#include<iostream>
int main(){
	int a,b,c;
	std::cin>>a>>b>>c;
	std::cout<<(a+b)%c<<"\n"<<(a%c+b%c)%c<<"\n"<<(a*b)%c<<"\n"<<(a%c*b%c)%c;
}