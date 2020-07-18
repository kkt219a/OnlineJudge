// 2003 - 수들의 합 2

#include<iostream>
using namespace std;
int n, m, j, s, c, a[10001], i;
int main() {
	for (cin >> n >> m; i < n;s==m?c++:c, i++)
		for (cin >> a[i], s+=a[i]; s > m; s -= a[j++]);
	cout << c;
}