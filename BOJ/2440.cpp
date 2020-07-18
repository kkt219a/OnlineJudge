//2440 - 별 찍기 -3
#include<iostream>
int N;
int main(){
	std::cin>>N;
	for(int i=0;i<N;i++){
		for(int j=N;j>i;j--)
			std::cout<<"*";std::cout<<"\n";
	}
}
