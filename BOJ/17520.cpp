// 17520 - Balanced String
#include<iostream>
int n,i,s=1;
int main(){
	for(std::cin>>n;i<(n%2+n)/2;s=s*2%16769023,i++);
	std::cout<<s;
}