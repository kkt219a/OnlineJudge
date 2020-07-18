//백준 - 6588 - 골드바흐의 추측
#include<iostream>
#include<math.h>
using namespace std;
int t, n, a[1000001], i, j;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(false);
	for (i = 2; i < 500001; i++) {
		if (a[i] == 1)
			continue;
		else
			for (j = 2; i*j < 1000001; a[i*j] = 1, j++);
	}
	for (;;) {
		cin >> n;
		if (!n)
			break;
		for (i = 2; i <= n/2; i++)
			if (a[i] == 0 && a[n - i] == 0) {
				cout << n << " = " << i << " + " << n - i << "\n";
				break;
			}
		if (i == n/2+1)
			cout << "Goldbach's conjecture is wrong.\n";
	}
}