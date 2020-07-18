//백준 - 윤년 - 2753
#include<iostream>
int y;
int main(){
	std::cin>>y;
	if((y%4==0&&y%100!=0)||y%400==0)
		std::cout<<"1";
	else
		std::cout<<"0";
}
