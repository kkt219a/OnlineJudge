//백준 - 10833 - 사과
#include<iostream>
int n,a,b,i,s;
int main(){
	std::cin>>n;
	for(;i<n;i++){
		std::cin>>a>>b;
		if(b/a!=0)
			s+=b%a;
		else
			s+=b;
	}
	std::cout<<s;
	
}