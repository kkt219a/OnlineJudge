//백준 - 11051 - 이항 계수 2
#include<iostream>
using namespace std;
int n, k, a[1001][1001], i, j;
int main() {
	for (cin >> n >> k;i <= n; i++)
		for (j = 0; j <= i;a[i][j] = (j == 0 || i == j) ? 1 : ((a[i - 1][j] + a[i - 1][j - 1])%10007), j++);
	cout << a[n][k];
}