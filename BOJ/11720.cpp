// 11720 - 숫자의 합

#include <iostream>
int t,n,i;
int main(){
	char k[101];
	std::cin>>t>>k;
	for(;i<t;i++)
		n+=(k[i]-'0');
	std::cout<<n;
}