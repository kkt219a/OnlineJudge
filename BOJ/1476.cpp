//백준 - 1476 - 날짜계산
#include<iostream>
int e,s,m,k=1;
int main(){
	std::cin>>e>>s>>m;
	for(;e!=s||s!=m||m!=1;e--,s--,m--,k++){
		if(e==0)
			e=15;
		if(s==0)
			s=28;
		if(m==0)
			m=19;
	}
	std::cout<<k;
}