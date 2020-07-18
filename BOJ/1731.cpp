// 백준 - 1731 - 추론
#include<iostream>
int n, a[50], i, c, d;
int main() {
	for (std::cin >> n; i < n; std::cin >> a[i], i++);
	if (a[n - 1] % a[n - 2] != 0) d = 2 * a[n - 1] - a[n - 2];
	else d = (a[n - 1] / a[n - 2])*a[n - 1];
	std::cout << d;
}