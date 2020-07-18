//4358 - 생태학 - 트라이

#include<iostream>
#include<memory.h>
#include<algorithm>
#include<string>
#include<cstring>
#include<vector>
using namespace std;
int i, visit[1000000];
char name[31];
vector<pair<string, int> > v;
class Trie {
public:
	Trie* t[128];
	int cnt;
	Trie() :cnt(0) { memset(t, 0, sizeof(t)); cnt = 0; }
	void insert(char* key) {
		if (*key == '\0') {
			cnt++;
			if(cnt==1)
				v.push_back(make_pair(name, cnt));
		}
		else {
			int cur = *key;
			if (t[cur] == NULL)
				t[cur] = new Trie();
			t[cur]->insert(key + 1);
		}
	}
	void find(char* key) {
		if (*key == '\0') {
			cout.precision(4);
			cout << fixed;
			cout << " " << ((double)cnt / i) * 100 << "\n";
		}
		else {
			cout << *key;
			int cur = *key;
			t[cur]->find(key + 1);
		}
	}
};
bool cmp(pair<string,int> a, pair<string,int> b) {
	return a.first < b.first;
}
int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	Trie* trie = new Trie();
	while (cin.getline(name,31)) {
		trie->insert(name);
		name[0] = '\0';
		i++;
	}
	sort(v.begin(), v.end(),cmp);
	for (int j = 0; j < v.size(); j++) {
		strcpy_s(name, v[j].first.c_str());
		trie->find(name);
	}
}