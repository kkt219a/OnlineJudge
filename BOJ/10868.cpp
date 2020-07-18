// 10868 - 최소값 - 세그먼트 트리

#include<iostream>
#include<math.h>
#include<algorithm>
#define inf 1000000001
using namespace std;
long long n, m, k, mint[400000], i, a, b, c;
int siz;
long long minseg(int left, int right, int start, int end, int node) {
	if (left > end || right < start) return inf;
	if (left <= start && right >= end) return mint[node];
	int mid = (start + end) / 2;
	return min(minseg(left, right, start, mid, node * 2), minseg(left, right, mid + 1, end, node * 2 + 1));
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> n >> m, siz = (1 << ((int)(log2(n) + 1))); i < n; cin >> mint[i+siz], i++);
	for (i = siz - 1; i > 0; mint[i] = min(mint[i * 2], mint[i * 2 + 1]), i--);
	for (i = 0; i < m; cin >> b >> c, cout << minseg(b + siz - 1, c + siz - 1, siz, 2 * siz - 1, 1) << "\n", i++);
}