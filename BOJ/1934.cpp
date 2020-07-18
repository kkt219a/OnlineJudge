// 1934 - 최소공배수

#include <iostream>
int c(int a,int b){
	if(b==0)
		return a;
	return c(b,a%b);
}
int main(){
	int N,a[1000],b[1000];
	std::cin>>N;
	for(int i=0;i<N;i++)
		std::cin>>a[i]>>b[i];
	for(int i=0;i<N;i++)
		std::cout<<(a[i]*b[i])/c(a[i], b[i])<<"\n";
}
