//5568 - 카드놓기 - 백트래킹 조합
#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;
int n, k, a[10], i, j, l, vi[10];
vector<string> v2;
vector<string>::iterator it;
vector<int> v;
void so(int x, int y) { // xCk
	if (k == y) {
		string st;
		for (l = 0; l < v.size(); st+=to_string(v[l++]));
		it = find(v2.begin(), v2.end(), st);
		if (it == v2.end())
			v2.push_back(st);
		return;
	}
	for (int p = 0; p < n; p++) {
		if (vi[p]) continue;
		v.push_back(a[p]);
		vi[p] = 1;
		so(p + 1, y + 1);
		vi[p] = 0;
		v.pop_back();
	}
}
int main() {
	for (cin >> n >> k; i < n; cin >> a[i++]);
	so(0, 0);
	cout << v2.size();
}