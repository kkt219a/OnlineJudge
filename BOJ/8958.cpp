//백준 - OX퀴즈 - 8958
#include<iostream>
#include<stdlib.h>
#include<cstring>
int n,i,j,k,s;
char a[80];
int main(){
	std::cin>>n;
	
	for(;i<n;i++){
		std::cin>>a;
		s=0;k=0;
		for(j=0;j<strlen(a);j++){
			if(a[j]=='O'){
				k++;
				s+=k;
			}
			else if(a[j]=='X')
				k=0;
		}
		memset(a,'X',sizeof(char)*80);
		std::cout<<s<<"\n";
	}
}