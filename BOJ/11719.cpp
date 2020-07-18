//백준 - 11719-그대로 출력하기  2
//rerererere
#include <iostream>  
int main() {
    char a[101];
    while (std::cin.getline(a,101)){
		if(a=="")
			break;
		std::cout<<a<<'\n';
	}
}