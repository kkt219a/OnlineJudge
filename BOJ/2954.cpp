//백준 - 창영이의 일기장 - 2954
//rerere getline 쪽
#include<iostream>
#include<cstring>
char b[999],i,j,k,t;
std::string a;
int main(){
	getline(std::cin,a);
	for(;i<a.size();i++){
		k=97;
		b[t++]=a[i];
		for(j=0;j<5;j++){
			if(a[i]==k)
				i+=2;
			if(j<2)
				k+=4;
			else
				k+=6;
		}
	}
	std::cout<<b;
}