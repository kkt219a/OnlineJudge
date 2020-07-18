// 1138-한줄로서기
#include<iostream>
int a[10], b, j, i, t, c[10];
int main() {
	for (std::cin >> b; i < b; i++) {
		std::cin >> a[i];
		c[i] = i + 1;
	}
	for (i--; i >= 0; i--) {
		for (j = 0; j < a[i]; j++) {
			t = c[i+j];
			c[i+j]=c[i + j + 1];
			c[i+j+1] = t;
		}
	}
	for (i = 0; i < b; i++)
		std::cout << c[i] << " ";
}