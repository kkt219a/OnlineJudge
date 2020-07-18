// 백준 - 10988 - 팰린드롬인지 확인하기 
#include<iostream>
#include<cstring>
char a[100];
int i,j,k=1;
int main(){
	std::cin>>a;
	for(i=strlen(a)-1;i>=0;i--,j++)
		if(a[i]!=a[j])
			k=0;
	std::cout<<k;
}