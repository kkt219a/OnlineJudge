// 14565 - 역원 구하기 - 확장 유클리드 호제법

#include<iostream>
using namespace std;
typedef long long ll;
ll n, a;
ll gcd(ll b, ll c) { return (b == 0) ? c : gcd(c % b, b); }
ll uc(ll b, ll c) {
	ll q, r1 = b, r2 = c, s1 = 0, s2 = 1, tmp;
	while (r2) {
		q = r1 / r2;
		tmp = r2;
		r2 = r1 - r2 * q;
		r1 = tmp;
		tmp = s2;
		s2 = s1 - s2 * q;
		s1 = tmp;
	}
	for (; s1 < 0; s1 += n);
	return s1;
}
int main() {
	cin >> n >> a;
	cout << n - a << " ";
	cout<<((gcd(a, n) != 1) ? -1 : uc(n,a));
}