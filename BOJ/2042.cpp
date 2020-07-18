// 2042 - 구간 합 구하기 - 세그먼트 트리

#include<iostream>
#include<math.h>
using namespace std;
long long n, m, k, a, b, c, i, siz, tree[3000000], in;

long long query(long long left, long long right, long long start, long long end, long long node) {
	if (end<left || start>right)
		return 0;
	else if (end <= right && start >= left)
		return tree[node];
	long long mid = (start + end) / 2;
	return query(left,right,start,mid,node*2) + query(left,right,mid+1,end,node*2+1);
}
void update(long long a) {
	for (long long j = a / 2; j > 0; tree[j] = tree[j * 2] + tree[j * 2 + 1], j /= 2);
}
int main() {
	cin.tie(0);
	cout.tie(0);
	ios_base::sync_with_stdio(0);
	for (cin >> n >> m >> k, siz = (1 << (int)(log2(n) + 1)); i < n; cin >> tree[i + siz], i++);
	for (i = siz - 1; i > 0;tree[i]=tree[i*2]+tree[i*2+1], i--);
	for (i = 0; i < m + k; i++) {
		cin >> a >> b >> c;
		if (a == 1) {
			tree[b + siz-1] = c;
			update(b+siz-1);
		}
		else
			cout<<query(b+siz-1, c+siz-1,siz,siz*2-1,1)<<"\n";
	}
}