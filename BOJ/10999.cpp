// 10999 - 구간 합 구하기2 - Lazy propagation

#include<iostream>
#include<math.h>
using namespace std;
typedef long long ll;
ll n, m, k, a, b, c, i, siz, tree[3000000], in, d, lazy[3000000];

void propagation(ll start, ll end, ll node) { // 이 구간내에 업데이트 할 거 남아 있을때만 내부 내용 업데이트
	if (lazy[node]!=0) {
		tree[node]+=(end - start + 1)* lazy[node];
		if (start != end) {
			lazy[node * 2]+= lazy[node];
			lazy[node * 2 + 1]+= lazy[node];
		}
		lazy[node] = 0;
	}
}
ll query(ll left, ll right, ll start, ll end, ll node) {
	propagation(start,end,node);
	if (end<left || start>right)
		return 0;
	else if (end <= right && start >= left)
		return tree[node];
	long long mid = (start + end) / 2;
	return query(left, right, start, mid, node * 2) + query(left, right, mid + 1, end, node * 2 + 1);
}
void update(ll left,ll right, ll start, ll end, ll node, ll f) {
	propagation(start,end,node);
	if (end<left || start>right) return;
	if (end <= right && start >= left) { // 구간 내에 있다면
		tree[node] += (end - start + 1) * f; // 현재 노드는 바로 업데이트
		if (start != end) {
			lazy[node * 2] += f;
			lazy[node * 2 + 1] += f;
		}
		return;
	}
	update(left, right, start, (start + end) / 2, node * 2, f);
	update(left, right, (start + end) / 2+1, end, node * 2+1, f);
	tree[node] = tree[node * 2] + tree[node * 2 + 1];
}
int main() {
	cin.tie(0);
	cout.tie(0);
	ios_base::sync_with_stdio(0);
	for (cin >> n >> m >> k, siz = (1 << (int)(log2(n) + 1)); i < n; cin >> tree[i + siz], i++);
	for (i = siz - 1; i > 0; tree[i] = tree[i * 2] + tree[i * 2 + 1], i--);
	for (i = 0; i < m + k; i++) {
		cin >> a >> b >> c;
		if (a == 1) {
			cin >> d; 
			update(b+siz-1,c+siz-1,siz,siz*2-1,1,d);
		}
		else
			cout << query(b + siz - 1, c + siz - 1, siz, siz * 2 - 1, 1) << "\n";
	}
}