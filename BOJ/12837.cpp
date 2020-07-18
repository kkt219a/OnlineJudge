// 12837 - 가계부(HARD) - 세그먼트 트리

#include<iostream>
#include<math.h>
#include<algorithm>
using namespace std;
long long n, m, k, tree[5000000], i, a, b, c, d;
int siz;
long long segment(long long left, long long right, long long start, long long end, long long node) {
	if (end < left || right < start) return 0;
	else if (left <= start && right >= end) return tree[node];
	long long mid = (start + end) / 2;
	return segment(left, right, start, mid, node * 2) + segment(left, right, mid + 1, end, (node * 2) + 1);
}
void up(long long bb) {
	for (long long i = bb / 2; i > 0; tree[i] = tree[i * 2] + tree[i * 2 + 1], i /= 2);
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> m;
	siz = (1 << ((int)(log2(n) + 1)));
	for (i = 0; i < m; i++) {
		cin >> a >> b >> c;
		if (a == 1) {
			tree[b + siz - 1] = c;
			up(b + siz - 1);
		}
		else
			cout << segment(b + siz - 1, c + siz - 1, siz, siz * 2 - 1, 1) << "\n";
	}
}
