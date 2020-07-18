// 11729 - 하노이 탑 이동 순서
#include<iostream>
#include<math.h>
int n;
void h(int k, int a, int b, int c) {
	if (k == 0)
		return;
	h(k - 1, a, c, b);
	std::cout << a << " " << c << "\n";
	h(k - 1, b, a, c);
}
int main() {
	std::cin >> n;
	std::cout << (int)pow(2, n)-1 << "\n";
	h(n,1,2,3);
}