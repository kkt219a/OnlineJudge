//백준 - 3052 - 나머지
#include<iostream>
int a,b[42],c=10;
int main(){
	while(c--){
		std::cin>>a;
		b[a%42]++;
	}
	for(a=0,c=0;c<42;c++)
		if(b[c]!=0)
			a++;
	std::cout<<a;
}