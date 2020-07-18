// 1759 - 단어수학 - 백트래킹

#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
char a[15], b[5] = { 'a','e','i','o','u' };
int l, c, i, v[15], k, cnt;
vector<char> v2;
void dfs(int x, int y) {
	if (y == l) {
		for (cnt = i = 0; i < l; i++)
			for (k = 0; k < 5; k++)
				if (v2[i] == b[k]) cnt++;
		if (cnt>0&&l-cnt>1) {
			for (i = 0; i < l; cout << v2[i++]);
			cout << "\n";
		}
		return;
	}
	for (int j = x; j < c; j++) {
		if (!v[j]) {
			v[j] = 1;
			v2.push_back(a[j]);
			dfs(j + 1, y + 1);
			v[j] = 0;
			v2.pop_back();
		}
	}
}
int main() {
	for (cin >> l >> c; i < c; cin >> a[i++]);
	sort(a, a + c);
	dfs(0, 0);
}