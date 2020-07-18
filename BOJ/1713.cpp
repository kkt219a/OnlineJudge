// 백준 - 1713 - 후보 추천하기 - 단순 구현 

#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n, m, k, i, j;
struct s { int n, r, d; };
vector<s> vs;
bool ch(s a, s b) {
	return (a.r == b.r) ? (a.d > b.d) : (a.r > b.r);
}
bool ch2(s a, s b) { return a.n < b.n; }
int main() {
	for (cin >> n >> m; i < m; i++) {
		cin >> k;
		s z = { k,1,i };
		for (j = 0; j < vs.size(); j++)
			if (vs[j].n == k)
				break;
		if (j != vs.size())
			vs[j].r++;
		else {
			if (vs.size() == n)
				vs.pop_back();
			vs.push_back(z);
		}
		sort(vs.begin(), vs.end(), ch);
	}
	for (sort(vs.begin(), vs.end(), ch2), i = 0; i < n; cout << vs[i++].n << " ");
}