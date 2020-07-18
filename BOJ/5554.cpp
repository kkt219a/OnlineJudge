//백준 - 5554 - 심부름 가는 길
#include<iostream>
int a, b, c, d;
int main(){
	std::cin>>a>>b>>c>>d;
	std::cout<<(a+b+c+d)/60<<"\n"<<(a+b+c+d)%60;
}