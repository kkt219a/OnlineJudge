//1330 - 두 수 비교하기

#include <iostream>
int a,b;
int main(){
	std::cin>>a>>b;
	if(a<b)
		std::cout<<"<";
	else if(a>b)
		std::cout<<">";
	else
		std::cout<<"==";
}