//10819 - 차이를 최대로 - 백트래킹

#include<iostream>
#include<vector>
#include<math.h>
#include<algorithm>
using namespace std;
int n, a[8], v[8], s, r = -999, i;
vector<int> vv;
void b(int k) {
	if (k == n) {
		for (s = 0, i = 0; i < n - 1; s += abs(vv[i] - vv[i + 1]), i++);
		r = max(r, s);
	}	
	else {
		for (int i = 0; i < n; i++) {
			if (v[i]) continue;
			v[i] = 1;
			vv.push_back(a[i]);
			b(k + 1);
			vv.pop_back();
			v[i] = 0;
		}
	}
}
int main() {
	for (cin >> n; i < n; cin >> a[i++]);
	b(0);
	cout << r;
}