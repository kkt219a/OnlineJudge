// 2243 - 사탕상자 - 세그먼트 트리

#include<iostream>
#include<math.h>
#include<algorithm>
#define inf 1000000
using namespace std;
long long n, m, k, tree[5000000], i, a, b, c, d;
int siz;
long long segment(long long k, long long start, long long end, long long node) {
	long long mid = (start + end) / 2;
	if (node >= siz && node < siz * 2 - 1&&k<=tree[node]) // 범위 내까지 node가 들어오면 얘다
		return node - siz + 1;
	if (k <= tree[node * 2])  // k가 더 작으면 왼쪽으로 계속 내려가기, k는 안 변하고
		return segment(k, start, mid, node * 2);
	else // k가 오른쪽에있으면 왼쪽값 빼주고 밑으로 내려가기
		return segment(k - tree[node * 2], mid + 1, end, node * 2 + 1);
}
void up(long long bb) {
	for (long long i = bb / 2; i > 0; tree[i] = tree[i * 2] + tree[i * 2 + 1], i /= 2);
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> m;
	siz = (1 << ((int)(log2(inf) + 1)));
	for (i = 0; i < m; i++) {
		cin >> a >> b;
		if (a == 1) { // 출력후 업데이트
			int se = segment(b, siz, siz * 2 - 1, 1);
			cout << se << "\n";
			tree[se + siz - 1]--;
			up(se + siz - 1);
		}
		else {
			cin >> c;
			tree[b + siz - 1] += c;
			up(b + siz - 1);
		}
	}
}