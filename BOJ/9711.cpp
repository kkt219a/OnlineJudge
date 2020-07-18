//9711 - 피보나치
#include<iostream>
using namespace std;
long long a[10001] = { 0,1,1, }, i = 3, mod = 2000000000, t, k, p, q;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (; i < 10001; a[i] = (a[i - 1] + a[i - 2])%mod,i++);
	for (cin >> t,i=1; i <= t; i++) {
		cin >> p >> q;
		cout << "Case #" << i << ": " << a[p]%q << "\n";
	}
}