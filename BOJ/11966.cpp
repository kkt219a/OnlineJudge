//백준 - 11966 - 2의 제곱인가?
#include<iostream>
int n;
int main(){
    std::cin>>n;
	std::cout<<((n&n-1)==0)?1:0;
}