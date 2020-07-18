//3955 - 캔디분배 - 확장 유클리드 호제법

#include<iostream>
#define maxed 1e9
using namespace std;
typedef long long ll; 
ll k, c, t;
ll gcd(ll a, ll b) { return (a == 0) ? b : gcd(b%a,a); }
void sol(ll k, ll c) {
	ll r1 = k, r2 = c, t1 = 0, t2 = 1, tmp = 0, q = 0;
	ll x, y;
	while (r2) {
		q = r1 / r2;
		tmp = r2;
		r2 = r1 % r2;
		r1 = tmp;
		tmp = t2;
		t2 = t1 - t2 * q;
		t1 = tmp;
	}
	for (; t1 < 0; t1 += k);
	if (t1 > maxed) cout << "IMPOSSIBLE\n";
	else cout << t1 << "\n";
}
int main() {
	//Kx - Cy = -1 을 만족하는 y의 값을 구하라
	//Kx+Cy=1 을 만족하는 음의 x와 양의 y값
	for (cin >> t; t--;) {
		cin >> k >> c;
		if (c == 1) { // 1봉지당 1개면 k+1명한테 주면 됨
			if (k + 1 > maxed) cout << "IMPOSSIBLE\n";
			else cout << k + 1 << "\n";
		}
		else if (k == 1) // 1명이면 1봉지 다주면 됨 
			cout << "1\n";
		else if (gcd(k, c) != 1)// 서로수가 아니면 불가능
			cout << "IMPOSSIBLE\n";
		else
			sol(k, c);
	}
}