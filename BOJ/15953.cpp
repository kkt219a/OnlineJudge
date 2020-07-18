//백준 - 상금헌터 - 15953(카카오 코드 페스티벌 2018 A)
#include<iostream>
int c(int a){
	int j;
	if(a>21||a==0)
		j=0;
	else if(a<2)
		j=5000000;
	else if(a<4)
		j=3000000;
	else if(a<7)
		j=2000000;
	else if(a<11)
		j=500000;
	else if(a<16)
		j=300000;
	else
		j=100000;
	return j;
	
}
int d(int b){
	int k=2,j=5120000;
	for(;k<=b&&b<32;k*=2,j/=2){}
	if(b>31||b==0)
		j=0;
	return j;
}
int main(){
	int t,a,b;
	std::cin>>t;
	for(;t>0;t--){
		std::cin>>a>>b;
		std::cout<<c(a)+d(b)<<"\n";
	}
}