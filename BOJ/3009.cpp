// 3009- 네번째 점
#include<iostream>
int x[1000], y[1000], a, b, i, c,d;
int main() {
	for (; i < 3; i++) {
		std::cin >> a >> b;
		x[a]++;
		y[b]++;
	}
	for (i = 0; i < 1000; i++) {
		if (x[i] == 1)
			c = i;
		if (y[i] == 1)
			d = i;
	}
	std::cout << c << " " << d;
}