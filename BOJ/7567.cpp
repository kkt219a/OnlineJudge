//백준 - 그릇 - 7567
#include<iostream>
#include<cstring>
char a[50];
int i=1,t;
int main(){
	std::cin>>a;
	for(;i<strlen(a);i++){
		if(a[i-1]==a[i])
			t+=5;
		else
			t+=10;
	}
	std::cout<<t+10;
}