//백준 - 6064 - 카잉 달력
#include<iostream>
using namespace std;
int m, n, x, y, t, s1, s2, ans;
int gcd(int a, int b) {
	if (a == 0)
		return b;
	return gcd(b%a, a);
}
int main() {
	for (cin >> t; t--;) {
		cin >> m >> n >> x >> y;
		if ((x - y)%gcd(m,n)!=0&&x-y!=0)
			ans = -1;
		else {
			if (m < n)
				for (s2 = ans = x; s2 != y; ans += m) {
					s2 = (s2 + m) % n;
					if (s2 == 0)
						s2 = n;
				}
			else
				for (s1 = ans = y; s1 != x; ans += n) {
					s1 = (s1 + n) % m;
					if (s1 == 0)
						s1 = m;
				}
		}
		cout << ans << "\n";
	}
}