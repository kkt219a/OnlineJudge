//백준 - 3460 - 이진수 
// 비트마스크로 rerere
#include<iostream>
int e,n,a[20][11],k,i;
int main(){
	std::cin>>e;
	for(;e--;){
		std::cin>>n;
		for(k=1,i=0;k<=n;k*=2,i++){}
		for(;n>=0&&k!=0;i--){
			if(n/k!=0){
				a[i][e]=1;
				n-=k;
			}
			k/=2;
		}
		for(i=0;i<20;i++)
			if(a[i][e])
				std::cout<<i<<" ";
		std::cout<<"\n";
	}
}