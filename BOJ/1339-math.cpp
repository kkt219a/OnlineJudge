//1339 - 단어수학 - 백트래킹이었으나 수학으로 품

#include<iostream>
#include<string.h>
#include<algorithm>
using namespace std;
int n, i, j, b[26], k, ans;
char a[11];
int main() {
	for (cin >> n; i < n; i++) {
		cin >> a;
		for (j = strlen(a) - 1, k = 1; j >= 0; b[a[j] - 65] += k, j--, k *= 10);
	}
	for (sort(b, b + 26, greater<int>()), i = 0, k = 9; b[i] != 0; ans += k * b[i], i++, k--);
	cout << ans;
}