//백준 - 돌 게임 - 9655
#include<iostream>
int n,i;
int main(){
	std::cin>>n;
	for(;n!=0;i++){
		if(n>3)
			n-=3;
		else
			n--;
	}
	if(i%2==1)
		std::cout<<"SK";
	else
		std::cout<<"CY";
	
}