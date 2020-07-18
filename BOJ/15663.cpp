// 15663 - N과 M(9)
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int n, m, p, vi[9], a[9];
vector<int> v;
void per(int k) {
	if (k == m) {
		for (p = 0; p < v.size(); cout << v[p++] << " ");
		cout << "\n";
	}
	bool ch[10001] = { 0, };
	for (int i = 1; i <= n; i++) {
		if (!vi[i] && !ch[a[i - 1]]) {
			vi[i] = 1;
			ch[a[i - 1]] = 1;
			v.push_back(a[i - 1]);
			per(k + 1);
			vi[i] = 0;
			v.pop_back();
		}
	}
}
int main() {
	for (cin >> n >> m; p < n; cin >> a[p++]);
	sort(a, a + n);
	per(0);
}