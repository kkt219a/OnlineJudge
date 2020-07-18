//11399 ATM

#include<iostream>
#include<algorithm>

int main(){
	int N,sum=0,p[1000];
	std::cin>>N;
	for(int i=0;i<N;i++)
		std::cin>>p[i];
	std::sort(p,p+N); 
	for(int i=0;i<N;i++)
		for(int j=0;j<=i;j++)
			sum+=p[j];
	std::cout<<sum;
}