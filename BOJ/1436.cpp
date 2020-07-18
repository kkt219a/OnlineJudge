// 1436-영화감독 숌-브루트보스
#include<iostream>
int n, c, i = 666, t;
int main() {
	std::cin >> n;
	for (; n != c; i++) {
		t = i;
		while (t) {
			if (t % 1000 == 666) {
				c++;
				break;
			}
			t /= 10;
		}
	}
	std::cout << i-1;
}