// 2086 - -2진수

#include<iostream>
using namespace std;
int n;
void b(int p) {
	if (p == 0) return;
	else if (p%-2 == 0) { b(p / -2); cout << "0"; }
	else { b((p - 1) / -2); cout << "1"; }
}
int main() {
	cin >> n;
	if (n == 0)
		cout << "0";
	else
		b(n);
}