// 2845 파티가 끝나고 난뒤

#include <iostream>

int L,P,r[5],i;

int main(){
	std::cin>>L>>P;
	for(;i<5;i++)
		std::cin>>r[i];
	
	for(i=0;i<5;i++)
		std::cout<<r[i]-L*P<<" ";
		
}