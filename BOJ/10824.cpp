//백준 - 10824 - 네수
#include<iostream>
long long a,b,c,d,i=1,j=1;
int main(){
	std::cin>>a>>b>>c>>d;
	for(;b/i>0;)
		i*=10;
	for(;d/j>0;)
		j*=10;
	std::cout<<a*i+b+c*j+d;
}