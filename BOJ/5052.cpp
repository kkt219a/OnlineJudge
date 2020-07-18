// 5052 - 전화번호 목록 - 트라이 - re 

#include<iostream>
#include<memory.h>
using namespace std;
int t, n, i; // t<=50, n<=10000, 전화번호는 10자리
char num[10001][11];
class Trie {
public:
	Trie* t[10];
	bool term;
	Trie() : term(0) {
		memset(t, 0, sizeof(t));
	}
	void insert(char* key) {
		if (*key == '\0')
			term = 1;
		else {
			int cur = *key - '0';
			if (t[cur] == NULL)
				t[cur] = new Trie();
			t[cur]->insert(key + 1);
		}
	}
	bool find(char* key) {
		if (*key == '\0') return 0;
		if (term) return 1;
		int cur = *key - '0';
		return t[cur]->find(key + 1);
	}
};
int main() {
	for (cin >> t; t--;) {
		Trie* root = new Trie();
		bool ok = 0;
		for (cin >> n, i = 0; i < n; num[i][0] = '\0', cin >> num[i], root->insert(num[i]), i++);
		for (i = 0; i < n; i++) {
			if (root->find(num[i])) {
				ok = 1;
				break;
			}
		}
		cout << (ok ? "No\n" : "Yes\n");
	}
}