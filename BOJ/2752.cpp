//백준 - 2752 - 세 수 정렬
#include<iostream>
#include<algorithm>
int a[3];
int main(){
	std::cin>>a[0]>>a[1]>>a[2];
	std::sort(a,a+3);
	std::cout<<a[0]<<" "<<a[1]<<" "<<a[2];
}