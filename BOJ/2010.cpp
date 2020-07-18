//백준 - 플러그 - 2010
#include<iostream>
int n,a[500001],s;
int main(){
	std::cin>>n;
	s-=n-1;
	for(;0<n;n--){
		std::cin>>a[n];
		s+=a[n];
	}
	std::cout<<s;
}