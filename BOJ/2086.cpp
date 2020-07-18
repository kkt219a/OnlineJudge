// 2086 - 피보나치 수의 합

#include<iostream>
using namespace std;
long long E[2][2] = { {1,1},{1,0} }, mat[2][2] = { {1,0},{0,1} }, tmp[2][2], mod = 1000000000, i, j, l, x, y;
void calc(long long a[][2], long long b[][2]) {
	for (i = 0; i < 2; i++)
		for (j = 0; j < 2; tmp[i][j] %= mod, j++)
			for (tmp[i][j] = 0, l = 0; l < 2; l++)
				tmp[i][j] += a[i][l] * b[l][j];
	for (i = 0; i < 2; a[i][0] = tmp[i][0], a[i][1] = tmp[i][1], i++);
}
long long cal(long long w) {
	if (w < 3)
		return w;
	for (w -= 2; w != 0; w /= 2) {
		if (w % 2)
			calc(mat, E);
		calc(E, E);
	}
	return (mat[0][0] + mat[0][1] + mat[1][0] + mat[1][1]) % mod;
}
int main() {
	cin >> x >> y;
	x=cal(x);
	E[0][0]=E[0][1]=E[1][0]=mat[0][0] = mat[1][1] = 1;
	E[1][1]=mat[0][1] = mat[1][0] = 0;
	y=cal(y+1);
	cout << (y-x+mod)%mod;
}