//9471 - 피사노 주기

#include<iostream>
using namespace std;
int p, n, m;
int k(int t) {
	int a = 0, b = 1, c = 0, d=1;
	do {
		d = (a+b) % t;
		a = b;
		b = d;
		c++;
	} while (a!=0||b!=1);
	return c;
}
int main() {
	for (cin >> p;p--; ) {
		cin >> n >> m;
		cout << n <<" " <<k(m)<<"\n";
	}
}
