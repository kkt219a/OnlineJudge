// 11727 - 2×n 타일링 2 - NO DP
#include<iostream>
int n, i=1, a=1;
int main() {
	std::cin >> n;
	for (; i < n; i++) {
		if (i % 2 == 1)
			a = (a * 2 + 1)%10007;
		else
			a = (a * 2 - 1)%10007;
	}
	std::cout << a;
		
}