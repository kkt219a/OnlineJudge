//백준 - 1057 - 토너먼트
//rerererererere
#include<iostream>
int n,m,k,r;
int main(){
	std::cin>>n>>m>>k;
	while(m!=k){
		m=(m+1)/2;
		k=(k+1)/2;
		r++;
	}
	std::cout<<r;
}