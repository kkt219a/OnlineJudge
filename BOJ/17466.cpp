// 17466 - N! mod P (1)
#include<iostream>
long long n, p, s = 1;
int main() {
	for (std::cin >> n >> p;n; s = (s%p)*(n--));
	std::cout << s;
}
