//백준 - 11047 - 동전 0 
#include<iostream>
using namespace std;
int n, k, a[10], c, i;
int main() {
	for (cin >> n >> k; i < n; cin >> a[i++]);
	for (; k != 0;) {
		if (k / a[--n] != 0) {
			c += k / a[n];
			k %= a[n];
		}
	}
	cout << c;
}