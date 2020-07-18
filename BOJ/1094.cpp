//백준 - 1094 - 막대기
#include<iostream>
int x,s=64,t=s,a=1;
int main(){
	std::cin>>x;
	for(;t>x;){
		s/=2;
		if(t-s>=x)
			t-=s;
		else
			a++;
	}
	std::cout<<a;
}