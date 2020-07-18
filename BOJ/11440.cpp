//백준 - 11440 - 피보나치 수의 제곱의 합
#include<iostream>
using namespace std;
long long E[2][2] = { {1,1},{1,0} }, mat[2][2] = { {1,0},{0,1} }, tmp[2][2], mod = 1000000007, n, k, i, j, l;
void calc(long long a[][2], long long b[][2]) {
	for (i = 0; i < 2; i++)
		for (j = 0; j < 2; tmp[i][j] %= mod, j++)
			for (tmp[i][j] = 0, l = 0; l < 2; l++)
				tmp[i][j] += a[i][l] * b[l][j];
	for (i = 0; i < 2; a[i][0] = tmp[i][0], a[i][1] = tmp[i][1], i++);
}
int main() {
	cin >> n;
	if (n < 2) {
		if (n != 0)
			k = 1;
	}
	else {
		for (n -= 1; n != 0; n /= 2) {
			if (n % 2)
				calc(mat, E);
			calc(E, E);
		}
		for (k = 1, n = 0; n < 2; k *= ((mat[n][0] + mat[n][1]) % mod), n++);
	}
	cout << k % mod;
}