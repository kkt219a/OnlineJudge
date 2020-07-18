//백준 - 1085 - 직사각형에서 탈출
#include<iostream>
#include<algorithm>
int a[6],j=2;
int main(){
	for(;j<6;j++){
		std::cin>>a[j];
		a[j]-=a[j-2];
	}
	std::sort(a,a+6);
	std::cout<<a[2];
}