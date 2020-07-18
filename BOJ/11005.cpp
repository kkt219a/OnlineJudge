//백준 - 11005 - 진법변환2
#include<iostream>
#include<cstring>
int n,b,c=1,d;
std::string a;
int main(){
	std::cin>>n>>b;
	for(;n/c>=b;)
		c*=b;
	for(;c>0;c/=b){
		d=n/c;
		if(d>9)
			a+=d+55;
		else
			a+=d+48;
		n-=c*d;
	}
	std::cout<<a;	
}