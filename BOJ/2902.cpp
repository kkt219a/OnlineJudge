//백준 - KMP는 왜 KMP일까 - 2902
#include<iostream>
#include<cstring>
char a[100],i;
int main(){
	std::cin>>a;
	for(;i<strlen(a);i++){
		if(a[i]<91&&a[i]>64)
			std::cout<<a[i];
	}
}