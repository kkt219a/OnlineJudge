//백준 - 5988 - 홀수일까 짝수일까
#include<iostream>
char k[60];
int n,i;
int main(){
	std::cin>>n;
	while(n--){
		std::cin>>k;
		for(i=0;k[i]!='\0';i++){}
		if((k[i-1]-'0')%2==0)
			std::cout<<"even\n";
		else
			std::cout<<"odd\n";
	}
}