// 백준 - 최대공약수와 최소공배수 - 2609
#include <iostream>
int c(int a,int b){
	if(b==0)
		return a;
	return c(b,a%b);
}
int main(){
	int a,b;
	std::cin>>a>>b;
	std::cout<<c(a,b)<<"\n"<<(a*b)/c(a,b);
}
