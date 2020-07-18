//2439 - 별 찍기 -2
#include<iostream>
int N;
int main(){
	std::cin>>N;
	for(int i=0;i<N;i++){
		for(int k=N-1;k>i;k--)
			std::cout<<" ";
		for(int j=0;j<=i;j++)
			std::cout<<"*";
		std::cout<<"\n";
	}
}