// 1395 - 스위치 - 세그먼트 트리 Lazy propagation

#include<iostream>
#include<math.h>
typedef long long ll;
using namespace std;
ll n, m, k, tree[2100000], i, a, b, c, d, lazy[2100000];
int siz;
void lazyu(ll start, ll end, ll node) { // 레이지에 어떠값이 있어야 트리에 잘 업데이트 해줄까?? 
	if (lazy[node] != 0) { // 여기 업데이트 할 거 있으면
		tree[node] = (end - start + 1)-tree[node]; // 이 범위의 개수 만큼 node에더해주기
		if (start != end) { //리프노드 아니면 자식들한테 값들 물려주기 얘네도 더해줘야 하니까!
			lazy[node * 2] ^= 1; // 기존 레이지의 무조건 반대값을!!
			lazy[node * 2 + 1] ^= 1;
		}
		lazy[node] = 0; // 그리고 이 노드는 이제 비워주기
	}
}
void up(ll left, ll right, ll start, ll end, ll node) { // 이렇게 쓰면 특정 구간합만 구해놓고 더 세부한건 레이지한테 맡겨버리는 것.
	lazyu(start, end, node); // 업데이트할 때 이 구간 lazy 있는지 확인
	if (end < left || right < start) return; // 범위 벗어 나는건 종료
	if (left <= start && end <= right) { // 범위에 들어오면 
		tree[node] = end-start+1-tree[node]; // 현재에 개수 반전 주기 리프라도 적용이 잘 됨
		if (start != end) { // 반전 준다고 표시만?
			lazy[node * 2] ^= 1; // 기존 레이지의 무조건 반대값을! 
			lazy[node * 2 + 1] ^= 1;
		}
		return;
	}
	up(left, right, start, (start + end) / 2, node * 2); // 구간 찾아들어가기
	up(left, right, (start + end) / 2 + 1, end, node * 2 + 1);
	tree[node] = tree[node * 2] + tree[node * 2 + 1];
}
ll query(ll left, ll right, ll start, ll end, ll node) {
	lazyu(start, end, node); // 구간 결과 출력 전에도 이 구간 lazy에 업데이트 할 거 있나 확인!
	if (end < left || right < start) return 0;
	else if (left <= start && right >= end) return tree[node];
	ll mid = (start + end) / 2;
	return query(left, right, start, mid, node * 2) + query(left, right, mid + 1, end, (node * 2) + 1);
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> n >> m, siz = (1 << ((int)(log2(n) + 1))); i < m + k; i++) {
		cin >> a >> b >> c;
		if (a == 0)
			up(b + siz - 1, c + siz - 1, siz, siz * 2 - 1, 1);
		else
			cout << query(b + siz - 1, c + siz - 1, siz, siz * 2 - 1, 1) << "\n";
	}
}