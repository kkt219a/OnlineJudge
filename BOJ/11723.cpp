// 11723 - 집합 - 비트마스크

#include<iostream>
#include<string>
using namespace std;
int t, n, inp, x;
string a;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> t; t--;a="") {
		cin >> a;
		if (a.compare("all") == 0) n |= (~(1 << 20));
		else if (a.compare("empty") == 0) n = 0;
		else {
			cin >> x;
			if (a.compare("add") == 0)  n |= (1 << x - 1);
			if (a.compare("remove") == 0)  n &= (~(1 << x - 1));
			if (a.compare("check") == 0) {
				if ((n&(1 << x - 1)) != 0) cout << "1\n";
				else cout << "0\n";
			}
			if (a.compare("toggle") == 0) n ^= (1 << x - 1);
		}
	}
}