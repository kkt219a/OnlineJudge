//백준 - Happy Number - 14954 (대전 icpc 예선문제)
#include<iostream>
int n,a,s;
const char *b;
int main(){
	std::cin>>n;
	while(1){
		s=0;
		for(;n!=0;){
			a=n%10;
			n/=10;
			s+=a*a;
		}
		n=s;
		if(n==1){
			b="HAPPY";
			break;
		}
		else if(n==4){
			b="UNHAPPY";
			break;
		}
	}
		std::cout<<b;
}