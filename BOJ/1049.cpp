//1049 - 기타줄
#include<iostream>
#include<algorithm>
using namespace std;
int n, m, i, q = 1001, p = 1001, e, r;
int main() {
	for (cin >> n >> m; i < m; i++) {
		cin >> e >> r;
		q = min(q, e);
		p = min(p, r);
	}
		cout << min(p*n,min(((n / 6)*q + (n % 6)*p),(n/6+1)*q));
}