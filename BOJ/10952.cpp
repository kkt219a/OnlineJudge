// 10952 - A+B - 5

#include<iostream>
int a,b;
int main(){
	while(1){
		std::cin>>a>>b;
		if(a==0&&b==0)
			break;
		std::cout<<a+b<<"\n";
	}
}