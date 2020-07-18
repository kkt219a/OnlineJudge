//백준 - 4539 - 반올림
#include<iostream>
using namespace std;
int n, m, c, d = 10, e;
int main() {
	for (cin >> n; n--; d = 10,c=0) {
		for (cin >> m; m / d != 0; c++, d *= 10);
		for (d = 5, e = 10; c; m = (m + d) / e * e, c--, d *= 10, e *= 10);
		cout << m << "\n";
	}
}
