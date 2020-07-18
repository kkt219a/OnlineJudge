//백준 - 10797 - 10부제
#include<iostream>
int d,a[5],i,j;
int main(){
	std::cin>>d;
	for(;i<5;i++){
		std::cin>>a[i];
		if(a[i]==d)
			j++;
	}
	std::cout<<j;
}