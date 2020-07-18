//백준 - 과제 안내신분 - 5597
#include<iostream>
int a[31],i,b[31];
int main(){
	for(;i<28;i++){
		std::cin>>a[i];
		b[a[i]]=a[i];
	}
	for(i=1;i<31;i++)
		if(b[i]==0)
			std::cout<<i<<"\n";
}