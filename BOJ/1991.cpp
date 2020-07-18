// 1991 - 트리순회 - 다시

#include<iostream>
using namespace std;
char b, c, d;
int n, i, a[26][2];
void preor(int k) {
	if (k==-1) return;
	cout << char(k + 65);
	preor(a[k][0]);
	preor(a[k][1]);
}
void inor(int k) {
	if (k==-1) return;
	inor(a[k][0]);
	cout <<char(k + 65);
	inor(a[k][1]);
}
void postor(int k) {
	if (k==-1) return;
	postor(a[k][0]);
	postor(a[k][1]);
	cout <<char(k+65);
}
int main() {
	for (cin >> n; i < n; i++) {
		cin >> b>>c>>d;
		a[b - 65][0] = (c == '.') ? -1 : c-65;
		a[b - 65][1] = (d == '.') ? -1 : d-65;
	}
	preor(0);
	cout << "\n";
	inor(0);
	cout << "\n";
	postor(0);
}