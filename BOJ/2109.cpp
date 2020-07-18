// 2109 - 순회 강연
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n, i = 1, d, p, m, j, c[10001], s,k;
vector<int> v[10001];
vector<int>::iterator v2;
bool e(int a, int b) { return a > b; }
int main() {
	for (cin >> n; n--;) {
		cin >> p >> d;
		m = max(m, d);
		v[d].push_back(p);
	}
	for (i=m; i >0; i--) {
		if (!v[i].empty()) {
			for (v2 = v[i].begin(); v2 != v[i].end(); v2++)
				c[j++] = *v2;
		}
		if (k < j) {
			sort(c+k, c + j, e);
			s += c[k++];
		}
	}
	cout << s;
}