//백준 - 1850 - 최대공약수
#include<iostream>
long long d,e,f;
int main(){
	std::cin>>d>>e;
	if(d>e){f=d;d=e;e=f;}
	while(d!=0){
		f=d;
		d=e%d;
		e=f;
	}
	for(;e--;) // 두 수의 최대공약수가 n만큼 1붙혀주기 이게 답!
		std::cout<<"1";
}