// 코테 레벨3


#include<iostream>
#include <string>
#include <vector>

using namespace std;
long long cnt;
int visit[21];
vector<int> v, ans;
bool f = 0;
void c(int l, int m, int o) {
	long long p, gop;
	if (l == o && !f) {
		cnt++;
		//cout<<cnt<<"z\n";
		if (cnt == m) {// 이제 이 벡터를 리턴해야하는데... 
			f = 1;
			ans = v;
		}
	}
	else if (!f) {
		for (p = 1, gop = 1; p < o - l; gop *= p, p++); // 자리수
		for (int i = 1; i <= o; i++) {
			if (visit[i]) continue;
			if (cnt + gop < m && !f) { cnt += gop; continue; }
			if (f) break;
			visit[i] = 1;
			v.push_back(i);
			c(l + 1, m, o);
			visit[i] = 0;
			v.pop_back();
		}
	}
}
vector<int> solution(int n, long long k) {
	vector<int> answer;
	c(0, k, n);
	answer = v;
	return ans;
}