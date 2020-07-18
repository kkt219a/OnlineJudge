//1568 - 새

#include<iostream>
int n,i=1,c;
int main(){
	for(std::cin>>n;n;i=n<i?1:i,n-=(i++),c++);
	std::cout<<c;
}