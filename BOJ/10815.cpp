//백준 - 숫자 카드 - 10815
#include<iostream>
#include<algorithm>
using namespace std;
int n, m, r[500000], w, i;
int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(false);
	for (cin >> n; i < n; i++)
		cin >> r[i];
	sort(r, r + n);
	for (cin >> m, i = 0; i < m; i++) {
		cin >> w;
		cout << binary_search(r, r + n, w) << " ";
	}
}