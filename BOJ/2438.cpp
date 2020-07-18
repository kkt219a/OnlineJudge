//2438 - 별 찍기 -1 
#include<iostream>
int N;
int main(){
	std::cin>>N;
	for(int i=0;i<N;i++){
		for(int j=0;j<=i;j++)
			std::cout<<"*";
		std::cout<<"\n";
	}
}