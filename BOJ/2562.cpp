//백준 - 최대값 - 2562 
#include<iostream>
#include<algorithm>
int i,j,v[9],m;
int main(){
	for(;i<9;i++){
		std::cin>>v[i];
		if(std::max(m,v[i])==v[i]){
			j=i;
			m=std::max(m,v[i]);
		}
	}
	std::cout<<m<<" "<<j+1;
	
}