// 백준 - 1837 - 암호제작
#include<iostream>
#include<math.h>
using namespace std;
int k, i = 2, a[1000001], j, f, s;
char b[101];
int main() {
	for (cin >> b >> k; i < k / 2; i++) {
		if (a[i])
			continue;
		else
			for (j = 2; i*j <= k; a[i*j] = 1, j++);
	}
	for (i = 2; i < k; i++) {
		if (!a[i]) {
			for (s = 0, j = 0; b[j]; s = (s * 10 + (b[j] - '0')) % i, j++);
			if (s == 0) {
				f = 1;
				s = i;
				break;
			}
		}
	}
	if (f)
		cout << "BAD " << s;
	else
		cout << "GOOD";
}
