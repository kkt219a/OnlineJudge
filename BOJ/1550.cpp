//백준 - 1550 - 16진수
#include<iostream>
#include<cstring>
char a[5];
int i,b,c=1,s;
int main(){
	std::cin>>a;
	for(i=strlen(a)-1;i>=0;i--){
		if(a[i]>64)
			b=a[i]-55;
		else
			b=a[i]-'0';
		s+=b*c;
		c*=16;
	}
	std::cout<<s;
}