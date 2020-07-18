// 11721 - 열 개씩 끊어 출력하기

#include <iostream>
int t=9,i;
int main(){
	char a[101];
	std::cin>>a;
	for(;a[i]!='\0';i++){
		std::cout<<a[i];
		if(i==t){
			std::cout<<"\n";t+=10;
		}
	}
}