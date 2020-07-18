// 2231-분해합-브루트포스
#include<iostream>
int n, i, j, k, t, s;
int main() {
	std::cin >> n;
	for (t=n; t != 0; t /= 10, i++);
	for (k = n - (9 * i); k < n; k++) {
		s = t = k;
		for (j = 0; j < i; j++, t /= 10)
			s += (t % 10);
		if (s == n) {
			std::cout << k;
			break;
		}
		s = 0;
	}
	if (k == n)
		std::cout << s;
}