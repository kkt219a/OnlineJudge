// 3044 - 체스판 조각

#include<iostream>
int n;
int main() {
	std::cin >> n;
	std::cout << (n/2+1)*(n/2+n%2+1);
}