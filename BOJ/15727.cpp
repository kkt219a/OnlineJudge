//백준 - 15727 - 조별과제를 하려는데 조장이 사라졌다
#include<iostream>
int a,b;
int main(){
    std::cin>>a;
	if(a%5!=0)
		b++;
	std::cout<<b+a/5;
}