// 2979 - 트럭주차
#include<iostream>
int a, b, c, d[100], e, f,g=3;
int main() {
	std::cin >> a >> b >> c;
	for (; g--;) {
		std::cin >> e >> f;
		for (; e < f; e++)
			d[e]++;
	}
	e = 0;
	for (g = 0; g < 100; g++) {
		if (d[g] == 1)
			e += d[g] * a;
		else if (d[g] == 2)
			e += d[g] * b;
		else if (d[g] == 3)
			e += d[g] * c;
	}
	std::cout << e;
}