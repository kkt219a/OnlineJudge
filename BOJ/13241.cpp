//백준 - 13241 - 최소공배수
#include<iostream>
long long int n,m,t;
long long int g(long long int a,long long int b){
	if(a==0)
		return b;
	return g(b%a,a);
}
int main(){
	std::cin>>n>>m;
	if(n>m){
		t=n;
		n=m;
		m=t;
	}
	t=g(n,m);
	std::cout<<n*m/t;
}