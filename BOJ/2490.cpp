//백준 - 윷놀이 - 2490
#include<iostream>

int a[12],k[3],i,j;
int main(){
	
	for(;i<12;i++){
		std::cin>>a[i];
		if(a[i]==0)
			k[j]++;
		if(i%4==3){
			if(k[j]==0)
				k[j]=5;
			j++;
		}
	}

	for(i=0;i<j;i++)
		std::cout<<(char)(k[i]+64)<<"\n";
}