//BOJ- 1789- 수들의 합

#include<iostream>
#include<math.h>
int main() {
	double a,b;
	std::cin >> a;
	b=(int)sqrt(a);
	for (; ((b+2)*(b + 1) / 2) <= a; b++);
	std::cout << (int)b;
	//4294967295
}