//백준 - ACM 호텔 - 10250
#include<iostream>
int t,i,j,k,h,w,n;
int main(){
	std::cin>>t;
	for(;i<t;i++){
		std::cin>>h>>w>>n;
		for(j=0;j<w&&n!=0;j++) 
			for(k=0;k<h&&n!=0;k++)
				n--;
		std::cout<<k*100+j<<"\n";
	}
}
