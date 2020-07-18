//1735 - 분수합 - 유클리드

#include<iostream>
using namespace std;
int gcd(int b, int c) { return (b == 0) ? c : gcd(c % b, b); }
int a, b, c, d, e;
int main() {
	cin >> a >> b >> c >> d;
	e = (a * d + c * b);
	cout << (e / gcd(e, b * d)) << " " << ((b * d) / gcd(e, b * d));
}