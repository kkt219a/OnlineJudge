//백준 - 문자열 반복 - 2675
#include<iostream>
#include<cstring>
char a[21];
int t,r,i,j;
int main(){
	std::cin>>t;
	while(t>0){
		std::cin>>r>>a;
		for(i=0;i<strlen(a);i++)
			for(j=0;j<r;j++)
				std::cout<<a[i];
		std::cout<<"\n";
		t--;
	}
}