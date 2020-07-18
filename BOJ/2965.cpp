#include<iostream>
int n,m,k;
int main(){
	std::cin>>n>>m>>k;
	std::cout<<(m-n>k-m?m-n:k-m)-1;
}