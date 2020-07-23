//13251 - 조약돌 꺼내기 - 조합론
#include<iostream>
using namespace std;
double a[2501][2501], sum;
int i, mm, j, m[50], k, sum2;
int main() {
	for (cin >> mm; i < mm; cin >> m[i++]);
	for (cin >> k, i = 0; i < 2501; i++)
		for (j = 0; j <= i; a[i][j] = (j == 0 || i == j) ? 1 : (a[i - 1][j] + a[i - 1][j - 1]), j++);
	for (i = 0; i < mm; sum += a[m[i]][k], sum2 += m[i], i++);
	cout << fixed;
	cout.precision(15);
	cout << sum / a[sum2][k];
}