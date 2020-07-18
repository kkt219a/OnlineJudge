// 11052 - 카드 구매하기
#include<iostream>
int d[1001], n, i=1, j, k;
int main() {
	std::cin >> n;
	for (; i <= n; i++) {
		std::cin >> j;
		if (d[i - 1] + d[1] < j)
			d[i] = j;
		else
			d[i] = d[i - 1] + d[1];
		for (k = i / 2; k <= i; k++)
			if (d[k] + d[i-k] > d[i])
				d[i] = d[k]+d[i-k];
	}
	std::cout << d[n];
}