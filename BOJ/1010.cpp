//1010 다리놓기- DP 조합

#include<iostream>
using namespace std;
int n, k, a[31][31], i, j, t;
int main() {
	for (; i <= 30; i++)
		for (j = 0; j <= i; j++)
			a[i][j] = (j == 0 || i == j) ? 1 : a[i - 1][j] + a[i - 1][j - 1];
	for (cin >> t; t--; cin >> n >> k, cout << a[k][n]<<"\n");
}