//백준 - 2587 - 대표값2
#include<iostream>
#include<algorithm>
int a[5],i,t;
int main(){
	for(;i<5;i++){
		std::cin>>a[i];
		t+=a[i];
	}
	std::sort(a,a+5);
	std::cout<<t/5<<"\n"<<a[2];
}