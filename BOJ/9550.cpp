//백준 - 아이들은 사탕을 좋아해 - 9550
#include<iostream>
#include<stdlib.h>
int t,n,k,i,j,*a,s;
int main(){
	std::cin>>t;
	for(;i<t;i++){
		std::cin>>n>>k;
		a=(int*)malloc(sizeof(int)*n);
		for(j=0;j<n;j++){
			std::cin>>a[j];
			s+=a[j]/k;
		}
		std::cout<<s<<"\n";;
		s=0;
		free(a);
	}
}