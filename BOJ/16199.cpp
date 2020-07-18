//백준 - 16199 - 나이 계산하기
#include<iostream>
int a,b,c,d,e,f;
int main(){
	std::cin>>a>>b>>c>>d>>e>>f;
	std::cout<<((d*365+e*30+f)-(a*365+b*30+c))/365<<"\n"<<d-a+1<<"\n"<<d-a;
}