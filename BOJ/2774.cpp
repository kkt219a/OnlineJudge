// 2774-아름다운수
#include<iostream>
int t, a, b[10], c, i;
int main() {
	std::cin >> t;
	for (; t--;) {
		c = 0;
		std::cin >> a;
		for (i = 0; i < 10; i++)
			b[i] = 0;
		for (;;) {
			b[a%10]++;
			a /= 10;
			if (a==0)
				break;
		}
		for (; a < 10; a++)
			if (b[a] != 0)
				c++;
		std::cout << c;
	}
}