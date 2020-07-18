//백준 - 평균 점수 - 10039
#include<iostream>
int a[5],i,s;
int main(){
	for(;i<5;i++){
		std::cin>>a[i];
		if(a[i]<40)
			a[i]=40;
		s+=a[i];
	}
	std::cout<<s/5;
}