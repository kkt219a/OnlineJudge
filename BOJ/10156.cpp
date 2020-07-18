//백준 - 10156 - 과자
#include<iostream>
int k,n,m,i;
int main(){
	std::cin>>k>>n>>m;
	i=k*n-m;
	if(i<0)
		i=0;
	std::cout<<i;
}