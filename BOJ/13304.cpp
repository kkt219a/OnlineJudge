//백준 - 13304 - 방배정 
#include<iostream>
int n,k,sy[2][7],i,j,h;
int main(){
	std::cin>>n>>k;
	for(;i<n;i++){
		std::cin>>h>>j;
		if(j%2==0) 
			j-=1;  
		if(h==1&&j<3) 
			h=0;
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