// 14438 - 수열과 쿼리17 - 세그먼트 트리 

#include<iostream>
#include<math.h>
#include<algorithm>
#define inf 1000000001
using namespace std;
long long n, m, k, tree[400000], i, a, b, c, d;
int siz;
long long minseg(int left, int right, int start, int end, int node) {
	if (left > end || right < start) return inf;
	if (left <= start && right >= end) return tree[node];
	int mid = (start + end) / 2;
	return min(minseg(left, right, start, mid, node * 2), minseg(left, right, mid + 1, end, node * 2 + 1));
}
void up(long long bb) {
	for (long long i = bb / 2; i > 0; tree[i] =min( tree[i * 2] , tree[i * 2 + 1]), i /= 2);
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> n , siz = (1 << ((int)(log2(n) + 1))); i < n; cin >> tree[i + siz], i++);
	for (i = siz - 1; i > 0; tree[i] = min(tree[i * 2] , tree[i * 2 + 1]), i--);
	for (cin>>m,i = 0; i < m; i++) {
		cin >> a >> b >> c;
		if (a == 1) {
			tree[b + siz - 1] = c;
			up(b + siz - 1);
		}
		else
			cout << minseg(b + siz - 1, c + siz - 1, siz, siz * 2 - 1, 1) << "\n";

	}
}