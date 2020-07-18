//백준 - 11655 - ROT13
#include<iostream>
#include<cstring>
std::string a;
int i,b;
int main(){
	getline(std::cin,a);
	for(;a[i]!='\0';i++){
		b=a[i];
		if(b>64)
			b+=13;
		if(b>90&&a[i]<91)
			a[i]=64-(90-b);
		else if(b>122&&a[i]>96)
			a[i]=96-(122-b);
		else
			a[i]=b;
	}
	std::cout<<a;
}