//9613 - GCD 합
#include<iostream>
#include<algorithm>
using namespace std;
int g(int m, int n) {
	if (n == 0)
		return m;
	return g(n, m%n);
}
int t, n, i, p[100], j;
long long sum;
int main() {
	for (cin >> t; t--;cout << sum << "\n") {
		for (cin >> n, i = 0,sum=0; i < n; cin >> p[i++]);
		for (i = 0; i < n - 1; i++)
			for (j = i + 1; j < n;sum += g(p[i], p[j]),j++);
	}
}