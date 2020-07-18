// 1062 - 가르침 - 백트래킹 re

#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;
int n, k, i, cnt, ar[26], vi[26], l, m, cntmp;
string a;
vector<string> v;
void back(int a, int b) {
	if (b == k - 5) { // 체크 후 cnt 맥스값
		for (cntmp=i = 0; i < v.size();i++) { // 단어들 불러오기
			for (l = 0; l < v[i].size(); l++) // 단어 한 글자씩
				if (!vi[v[i][l] - 97])
					break;
			if (v[i].size() == l) // 단어가 전부 일치하면 그 단어 습득 가능
				cntmp++;
		}
		cnt = max(cntmp, cnt);
		return;
	}
	for (int j = a; j < 26; j++) {
		if (!vi[j]) { //방문 안했고 저게 있으면
			vi[j] = 1;
			back(j+1 , b + 1);
			vi[j] = 0;
		}
	}
}
int main() {
	for (cin >> n >> k; i < n; i++) {
		cin >> a;
		a = a.substr(4, a.length() - 8);
		v.push_back(a);
		for (l = 0; l < a.size();ar[a[l]-97]=1, l++);
	}
	vi[0] = vi[2] = vi[8] = vi[13] = vi[19] = 1;
	if (k > 4)
		back(0, 0);
	cout << cnt;
}