//백준 -뜨거운 붕어빵- 11945
#include<iostream>
char a[11][11];
int n,m,j,i;
int main(){
	std::cin>>n>>m;
	for(;i<n;i++){
		std::cin>>a[n];
		for(j=m-1;j>=0;j--)
			std::cout<<a[n][j];
		std::cout<<"\n";
	}
}