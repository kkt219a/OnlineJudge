//백준 - 카드게임 - 5522
#include<iostream>
int t=5,a,b;
int main(){
	while(t>0){
		std::cin>>a;
		b+=a;
		t--;
	}
	std::cout<<b;
}