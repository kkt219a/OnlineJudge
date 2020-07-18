//2441 - 별 찍기 -4
#include<iostream>
int N;
int main(){
	std::cin>>N;
	for(int i=0;i<N;i++){
		for(int j=0;j<i;j++)
			std::cout<<" ";
		for(int k=N;k>i;k--)
			std::cout<<"*";std::cout<<"\n";
	}
}

