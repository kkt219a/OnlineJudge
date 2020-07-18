//백준 - 점수계산 - 2506
#include<iostream>
int n,a,i,s,c;
int main(){
	std::cin>>n;
	for(;i<n;i++){
		std::cin>>a;
		if(a==0)
			c=0;
		else
			c++;
		s+=c;
	}
	std::cout<<s;	
}