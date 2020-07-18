//백준 - 인공지능 시계 - 2530
#include<iostream>
int a,b,c,d; //d가 초
int main(){
	std::cin>>a>>b>>c>>d;
	d+=b*60+a*3600+c;
	while(d>86399)
		d-=86400;
	
	std::cout<<d/3600<<" "<<d%3600/60<<" "<<d%3600%60;
}