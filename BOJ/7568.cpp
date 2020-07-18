// 7568-덩치-브루트포스
#include<iostream>
int n, a[50], b[50], i, j, k;
int main() {
	std::cin >> n;
	for (; i < n; i++)
		std::cin >> a[i] >> b[i];
	for (i = 0; i < n; i++,k=0) {
		for (j = 0; j < n; j++)
			if (a[i] < a[j] && b[i] < b[j])
				k++;
		std::cout << k + 1 << " ";
	}
}