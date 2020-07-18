//백준 - 8393 - 합
#include<iostream>
int N,s;
int main(){
	std::cin>>N;
	for(;0<N;N--)
		s+=N;
	std::cout<<s;
}