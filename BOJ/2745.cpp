//백준 - 2745 - 진법 변환
#include<iostream>
#include<cstring>
char a[31];
int i,n,k=1,t,m;
int main(){
	std::cin>>a>>n;
	for(i=strlen(a)-1;i>=0;i--,k*=n){
		if(a[i]>64)
			m=a[i]-55;
		else
			m=a[i]-48;
		t+=m*k;
	}
	std::cout<<t;
	
}