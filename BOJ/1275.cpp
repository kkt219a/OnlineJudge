//1275 - 커피숍2 - 세그먼트 트리

#include<iostream>
#include<math.h>
#include<algorithm>
using namespace std;
typedef long long ll;
ll tree[300000], n, q, siz, x, y, a, b, i;
ll query(ll left, ll right, ll start, ll end, ll node) {
	if (end < left || right < start)
		return 0;
	if (start >= left && right >= end)
		return tree[node];
	return query(left, right, start, (start + end) / 2, node * 2) + query(left, right, (start + end) / 2 + 1,end, node * 2 + 1);
}
void update(ll k) {
	for (ll j = k/2; j > 0; tree[j] = tree[j * 2] + tree[j * 2 + 1], j /= 2);
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (cin >> n >> q, siz = (1 << ((int)log2(n) + 1)); i < n; cin >> tree[siz + i], i++);
	for (i = siz - 1; i > 0; tree[i] = tree[i * 2] + tree[i * 2 + 1], i--);
	for (; i < q; i++) {
		cin >> x >> y >> a >> b;
		if (x > y) swap(x, y);
		cout << query(x+siz-1, y+siz-1, siz, siz*2-1, 1) << "\n";
		tree[a + siz-1] = b;
		update(a+siz-1);
	}
}