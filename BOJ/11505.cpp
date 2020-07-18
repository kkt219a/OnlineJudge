// 11505 - 구간 곱 구하기 - 세그먼트 트리

#include<iostream>
#include<math.h>
#include<string.h>
using namespace std;
long long n, m, k, tree[3000000], i, a, b, c, mod = 1000000007;
int siz;
long long segment(long long left, long long right, long long start, long long end, long long node) {
	if (end < left || right < start) return 1;
	else if (left <= start && right >= end) return tree[node] % mod;
	long long mid = (start + end) / 2;
	return ((segment(left, right, start, mid, node * 2) % mod) * (segment(left, right, mid + 1, end, (node * 2) + 1) % mod)) % mod;
}
void up(long long bb) {
	for (long long i = bb / 2; i > 0; tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % mod, i /= 2);
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	for (i = 1; i < 3000000; i++)
		tree[i] = 1;
	for (i = 0, cin >> n >> m >> k, siz = (1 << ((int)(log2(n) + 1))); i < n; cin >> tree[i + siz], i++);
	for (i = siz - 1; i > 0; tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % mod, i--);
	for (i = 0; i < m + k; i++) {
		cin >> a >> b >> c;
		if (a == 1) { tree[b + siz - 1] = c; up(b + siz - 1); }
		if (a == 2) cout << segment(b + siz - 1, c + siz - 1, siz, siz * 2 - 1, 1) << "\n";
	}
}