//백준 - 13300 - 방배정 
#include<iostream>
int n,k,sy[2][7],i,j,h;
int main(){
	std::cin>>n>>k;
	for(;i<n;i++){
		std::cin>>h>>j;
		sy[h][j]++;
	}
	i=0;
	for(h=0;h<2;h++)
		for(j=1;j<7;j++){
			i+=sy[h][j]/k;
			if(sy[h][j]!=0&&sy[h][j]%k!=0)
				i++;
		}
	
	std::cout<<i;
}