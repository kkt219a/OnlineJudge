// 15661 - 링크와 스타트 - 백트래킹

#include<iostream>
#include<vector>
#include<algorithm>
#include<math.h>
using namespace std;
int n, i, j, a[20][20], p, ret = 987654321;
bool vi[20];
vector<int> c, d;
void back(int nn, int cur) {
	if (nn != 0) { //한명 이상이니까
		int s1 = 0, s2 = 0;
		for (i = 0; i < n; i++) if (!vi[i]) d.push_back(i); // d팀 만들어주고
		for (i = 0; i < c.size(); i++) for (j = 0; j < c.size(); s1 += a[c[i]][c[j]], j++);
		for (i = 0; i < d.size(); i++) for (j = 0; j < d.size(); s2 += a[d[i]][d[j]], j++);
		ret = min(ret, abs(s1 - s2));
		d.clear(); //d팀 정리
	}
	for (int k = cur; k < n; k++) { // 0번 친구부터 쭉 가보세유~
		if (!vi[k]) {
			vi[k] = 1;
			c.push_back(k);
			back(nn + 1, k);
			c.pop_back();
			vi[k] = 0;
		}
	}
}
int main() {
	for (cin >> n; i < n; i++)
		for (j = 0; j < n; cin >> a[i][j++]);
	back(0,0);
	cout << ret;
}