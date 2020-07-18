//백준 - 14582 - 오늘도 졌다
#include<iostream>
int a[9],b[9],i,s,v;
bool c;
int main(){
	for(;i<9;i++)
		std::cin>>a[i];
	for(i=0;i<9;i++)
		std::cin>>b[i];
	for(i=0;i<9;i++){
		s+=a[i];
		if(s>v)
			c=1;
		v+=b[i];
	}
	if(c)
		std::cout<<"Yes";
	else
		std::cout<<"No";
	
}