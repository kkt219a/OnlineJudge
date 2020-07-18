// 2503-숫자야구
#include<stdio.h>
#pragma warning(disable:4996)
int k, arr, a[3], b, s, i, j, n, l, m, arr2[3], arr3[999], b2, s2, cnt, o;
int main() {
		for (scanf("%d", &k), o = k; o--;) {
			scanf("%d %d %d", &arr, &s, &b);

			for (j = 2; j >= 0; j--, arr /= 10)
				a[j] = arr % 10;

			for (n = 123; n <= 987; n++, b2 = 0, s2 = 0) {
				for (l = n, j = 2; j >= 0; j--, l /= 10)
					arr2[j] = l % 10;
				if (arr2[0] != 0 && arr2[1] != 0 && arr2[2] != 0 && arr2[0] != arr2[1] && arr2[0] != arr2[2] && arr2[1] != arr2[2]) {
					for (l = 0; l < 3; l++) { 
						for (m = 0; m < 3; m++) {
							if (l == m&&a[l] == arr2[m])
								s2++;
							else if (l != m&&a[l] == arr2[m])
								b2++;
						}
					}
					if (b2 == b&&s2 == s) // 진짜로 맞다? 그 숫자에 값 +시켜주기
						arr3[arr2[0] * 100 + arr2[1] * 10 + arr2[2]]++;
				}
			}
		}
		for (l = 123; l <= 987; l++)
			if (arr3[l] == k)
				cnt++;
		printf("%d\n", cnt);

}