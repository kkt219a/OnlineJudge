// 5676 - 음주코딩 - 세그먼트 트리

#include<iostream>
#include<math.h>
#include<string.h>
#include<vector>
using namespace std;
int n, m, k, tree[500000], i, a, b, c, siz;
vector<char> val;
void ch(int l) {
	if (tree[l] > 0) tree[l] = 1;
	else if (tree[l] < 0) tree[l] = -1;
}
int  segment(int  left, int  right, int  start, int  end, int node) {
	if (end < left || right < start) return 1;
	else if (left <= start && right >= end) return tree[node];
	int mid = (start + end) / 2;
	return segment(left, right, start, mid, node * 2) * segment(left, right, mid + 1, end, (node * 2) + 1);
}
void up(int bb) {
	for (int i = bb / 2; i > 0; i /= 2) {
		tree[i] = tree[i * 2] * tree[i * 2 + 1];
		ch(i);
	}
}
char f;
int main() {
	while (cin>>n>>m) {
		if (cin.eof() == true)
			break;
		for (i = 1; i < 500000; i++)
			tree[i] = 1;
		for (i = 0, siz = (1 << ((int)(log2(n) + 1))); i < n; i++) {
			cin>>tree[i + siz];
			ch(i + siz);
		}
		for (i = siz - 1; i > 0; i--) {
			tree[i] = tree[i * 2] * tree[i * 2 + 1];
			ch(i);
		}
		for (i = 0; i < m; i++) {
			//getchar();
			cin >> f >> b >> c;
			if (f == 'C') { tree[b + siz - 1] = c; up(b + siz - 1); }
			if (f == 'P') {
				int ml = segment(b + siz - 1, c + siz - 1, siz, siz * 2 - 1, 1);
				if (ml < 0) f = '-';
				else if (ml > 0) f = '+';
				else f = '0';
				val.push_back(f);
			}
		}
		for (i = 0; i < val.size(); i++)
			cout << val[i];
		cout << "\n";
		val.clear();
	}
}