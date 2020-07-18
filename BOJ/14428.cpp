//14428 - 수열과 쿼리 16 - 세그먼트 트리

#include<iostream>
#include<math.h>
#include<algorithm>
#include<utility>
#define inf 1000000001
typedef long long ll;
using namespace std;
long long n, m, k, i, a, b, c, d, p;
pair<ll, ll> tree[400000];
int siz;
pair<ll,ll> minseg(int left, int right, int start, int end, int node) {
	if (left > end || right < start) return make_pair(inf, inf);
	if (left <= start && right >= end) return tree[node];
	int mid = (start + end) / 2;
	return min(minseg(left, right, start, mid, node * 2), minseg(left, right, mid + 1, end, node * 2 + 1));
}
void up(long long bb) {
	for (long long i = bb / 2; i > 0; i /= 2) {
		if (tree[i * 2].first >= tree[i * 2 + 1].first) {
			(tree[i * 2].first == tree[i * 2 + 1].first) ? tree[i].second = tree[i * 2].second : tree[i].second = tree[i * 2+1].second;
			(tree[i * 2].first == tree[i * 2 + 1].first) ? tree[i].first = tree[i * 2].first : tree[i].first = tree[i * 2 + 1].first;
		}
		else {
			tree[i].second = tree[i * 2].second;
			tree[i].first = tree[i * 2].first;
		}
	}
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (cin >> n, siz = (1 << ((int)(log2(n) + 1))); i < n; cin >> p,tree[i+siz]=make_pair(p,i+1), i++);
	for (i = siz - 1; i > 0; i--) {
		if (tree[i * 2].first >= tree[i * 2 + 1].first) {
			(tree[i * 2].first == tree[i * 2 + 1].first) ? tree[i].second = tree[i * 2].second : tree[i].second = tree[i * 2+1].second;
			(tree[i * 2].first == tree[i * 2 + 1].first) ? tree[i].first = tree[i * 2].first : tree[i].first = tree[i * 2 + 1].first;
		}
		else {
			tree[i].second = tree[i * 2].second;
			tree[i].first = tree[i * 2].first;
		}
	}
	for (cin >> m, i = 0; i < m; i++) {
		cin >> a >> b >> c;
		if (a == 1) {
			tree[b + siz - 1].first = c;
			up(b + siz - 1);
		}
		else
			cout << minseg(b + siz - 1, c + siz - 1, siz, siz * 2 - 1, 1).second << "\n";
	}
}