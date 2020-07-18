//백준 - 10178 - 할로윈의 사탕
#include<iostream>
int t,a,b;
int main(){
	cin>>t;
	for(;t>0;t--){
		std::cin>>a>>b;
		std::cout<<"You get "<<a/b<<" piece(s) and your dad gets "<<a%b<<" piece(s).\n";
	}
}