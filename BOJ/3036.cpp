// 3036 - 링

#include<iostream>
int n[101],t,i,k;
int g(int a,int b){
	int p;
	if(a>b){
		p=a;
		a=b;
		b=p;
	}
	if(a==0)
		return b;
	return g(b%a,a);
}
int main(){
	for(std::cin>>t;i<t;i++)
		std::cin>>n[i];
	for(i=1;i<t;i++){
		k=g(n[0],n[i]);
		std::cout<<n[0]/k<<"/"<<n[i]/k<<"\n";
	}
}