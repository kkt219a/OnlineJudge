//백준 - 1152 - 단어의 개수
#include<iostream>
#include<cstring>
std::string a;
int i,t;
int main(){
	getline(std::cin,a);
	for(;i<a.size();i++)
		if(a[i]!=32&&a[i+1]<60)
			t++;
	std::cout<<t;
}