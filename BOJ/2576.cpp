//백준 - 홀수 - 2576
#include<iostream>
#include<algorithm>

int a,m=101,s,i;
int main(){
	for(;i<7;i++){
		std::cin>>a;
		if(a%2!=0){
			s+=a;
			m=std::min(m,a);
		}
	}
	if(s==0)
		std::cout<<"-1";
	else
		std::cout<<s<<"\n"<<m;
}