//백준 - 10872 - 팩토리얼(1)
#include<iostream>
int n;
int f(int n){
	if(n==0||n==1)
		return 1;
	return f(n-1)*n;
}
int main(){
	std::cin>>n;
	std::cout<<f(n);
}