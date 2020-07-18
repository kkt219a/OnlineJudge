// 14491 - 9진수

#include<iostream>
int t,i=1,c;
int main() {
	for(std::cin>>t;i<=t;i*=9,c++);
	for(i/=9;t!=0;std::cout<<t/i,t%=i,i/=9,c--);
	for(;c--;std::cout<<"0");
}