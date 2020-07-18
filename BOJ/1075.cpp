// 1075-나누기
#include<stdio.h>
int n, f, a, i;
int main() {
	scanf("%d %d", &n, &f);
	a = (n / 100) * 100;
	for (;; i++)
		if ((a + i) % f == 0) {
			printf("%02d", (a + i) % 100);
			break;
		}
}