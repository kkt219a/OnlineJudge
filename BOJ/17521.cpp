// 17521 - Byte Coin
#include<iostream>
using namespace std;
int n, s[16], i = 1, pa,f;
long long w;
int main() {
	for (cin >> n >> w; i <= n; cin >> s[i++]);
	for (i = 1; i <= n; i++) {
		if (s[i] < s[i + 1] && f == 0) {
			pa = s[i];
			f = 1;
		}
		if (s[i] > s[i + 1] && f == 1) {
			w = (w/pa)*s[i]+(w%pa);
			f = 0;
		}
	}
	if (f)
		w = (w / pa)*s[n] + (w%pa);
	cout << w;
}