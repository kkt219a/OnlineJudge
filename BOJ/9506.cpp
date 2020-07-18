//9506 - 약수들의 합
#include<iostream>
using namespace std;
int n, i, c, a[10000], s;
int main() {
	for (;;) {
		cin >> n;
		if (n==-1)
			break;
		for (s = 0, c = 0, i = 1; i <= n / 2; i++) {
			if (n%i == 0) {
				a[c] = i;
				s += a[c++];
			}
		}
		if (s == n) {
			cout << n << " = ";
			for (i = 0; i < c-1; i++)
				cout << a[i] << " + ";
			cout << a[c-1]<<"\n";
		}
		else
			cout << n << " is NOT perfect.\n";
	}
}