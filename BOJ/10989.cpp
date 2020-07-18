// 10989-수 정렬하기3
#include<iostream>
int a[10001], n, i, b, j;
using namespace std;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> n;
	for (; i < n; i++) {
		cin >> b;
		a[b]++;
	}
	for (i = 1; i < 10001; i++) {
		for (j = 0; j < a[i]; j++)
			cout << i << "\n";
	}
}