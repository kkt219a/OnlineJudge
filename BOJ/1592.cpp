//백준 - 1592 - 영식이와 친구들
#include<iostream>
int n,m,l;
int g(int a,int b){
	if(a==0)
		return b;
	return g(b%a,a);
}
int main(){
	std::cin>>n>>m>>l;
	std::cout<<(n/g(n,l))*(m-1);
}