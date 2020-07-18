// 백준 - 1748 - 수 이어 쓰기1
#include<iostream>
int N,s,a=10,b=1;
int main(){
	std::cin>>N;
	for(int i=1;i<=N;i++){
		if (a==i){
			b++; a *= 10;
		}
		s += b;
	}
	std::cout<<s;
}
