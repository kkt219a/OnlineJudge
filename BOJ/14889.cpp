//14889 - 스타트와 링크 - 백트래킹 조합 

#include<iostream>
#include<vector>
#include<math.h>
#include<algorithm>
using namespace std;
vector<int> v, v2;
int vi[21], i = 1, n, a[21][21], j, s1, s2, ans = 987654321;
void back(int k,int p) {
	if (k == n / 2) {
		for (s1 = s2 = 0, i = 1; i <= n; i++) {
			if (!vi[i]) v2.push_back(i);
			else v.push_back(i);
		}
		for (i = 0; i < n / 2; i++)
			for (j = 0; j < n / 2; j++) {
				if (i == j) continue;
				s1 += a[v[i]][v[j]];
				s2 += a[v2[i]][v2[j]];
			}
		ans = min(ans, abs(s1 - s2));
		v2.clear();
		v.clear();
	}

	else
		for (int i = p; i <= n; i++)
			if (!vi[i]) {
				vi[i] = 1;
				back(k + 1,i);
				vi[i] = 0;
			}
}
int main() {
	for (cin >> n; i <= n; i++)
		for (j = 1; j <= n; cin >> a[i][j++]);
	back(0,1);
	cout << ans;
}