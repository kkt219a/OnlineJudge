//백준 - 크냐? - 4101
#include<iostream>
int a,b;
int main(){
	while(1){
		std::cin>>a>>b;
		if(a>b)
			std::cout<<"Yes\n";
		else if(a==0&&b==0)
			break;
		else
			std::cout<<"No\n";
	}
}