// 1072-게임
#include<iostream>
#include<math.h>
long long x, y, z, c, f, l, m, a;
int main() {
	std::cin >> x >> y;
	z = 100 * y / x;
	if (z > 98)
		f = -1;
	else {
		f = 1;
		l = x;
		while (f <= l) {
			m = (f + l) / 2;
			a = 100 * (y + m) / (x + m);
			if (z<a)
				l = m - 1;
			else
				f = m + 1;
		}
	}
	std::cout << f;
}