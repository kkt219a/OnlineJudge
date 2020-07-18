//백준 - 더하기 - 9085
#include<iostream>
int t,n,a,i,j,s;
int main(){
	std::cin>>t;
	for(;i<t;i++){
		s=0;
		std::cin>>n;
		for(j=0;j<n;j++){
			std::cin>>a;
			s+=a;
		}
		std::cout<<s<<"\n";;
	}
}