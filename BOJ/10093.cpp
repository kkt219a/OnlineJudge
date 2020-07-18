// 10093-숫자
#include<iostream>
long long a, b, tmp;
int main() {
	std::cin >> a >> b;
	if (a > b) {
		tmp = a;
		a = b;
		b = tmp;
	}
	if (a == b) b++;
	std::cout << b - a - 1<<"\n";
	for (; a < b-1; a++)
		std::cout << a+1<<" ";
}
