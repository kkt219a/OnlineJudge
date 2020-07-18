//백준 - 개수 세기 - 10807
#include<iostream>
int n,a[100],v,i,z;
int main(){
	std::cin>>n;
	for(;i<n;i++)
		std::cin>>a[i];
	std::cin>>v;
	for(i=0;i<n;i++)
		if(a[i]==v)
			z++;
	std::cout<<z;
}