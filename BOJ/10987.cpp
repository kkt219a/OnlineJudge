//백준 - 10987 - 모음의 개수
#include<iostream>
int t,a;
char c[100];
int main(){
	std::cin>>c;
	for(;c[t]!='\0';t++){
		switch(c[t]){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				a++;
				break;
		}
	}
	std::cout<<a;
}