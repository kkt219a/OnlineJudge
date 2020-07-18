//백준 - 상수 - 2908
#include<iostream>
int a,b;
int c(int a){
	return a/100+((a%100)/10)*10+((a%100)%10)*100;
}
int main(){
	std::cin>>a>>b;
	if(c(a)>c(b))
		std::cout<<c(a);
	else
		std::cout<<c(b);
}