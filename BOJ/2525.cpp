//백준 - 오븐시계 - 2525
#include<iostream>
int a,b,c;
int main(){
	std::cin>>a>>b>>c;
	b+=a*60+c;
	if(b>1439)
		b-=1440;
	std::cout<<b/60<<" "<<b%60;
}