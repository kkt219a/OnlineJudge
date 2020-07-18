//10821 - 정수의 개수 

#include<iostream>
char a[101];
int b,i;
int main(){
	std::cin>>a;
	for(;i<101;i++)
		if(a[i]==',')
			b++;
	std::cout<<b+1;
}