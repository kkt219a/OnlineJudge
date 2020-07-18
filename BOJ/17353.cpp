// 17353 - 하늘에서 떨어지는 1, 2, ..., R-L+1개의 별 - 세그먼트 트리

#include<iostream>
#include<math.h>
typedef long long ll;
using namespace std;
struct pp {
	ll value, cnt;
};
ll n, m, k, i, a, b, c, d;
pp tree[500000];
int siz;
void up(ll left, ll right, ll start, ll end, ll node) { 
	if (end < left || right < start) return; // 범위 벗어 나는건 종료
	if (left <= start && end <= right) { // 범위에 들어올때마다
		tree[node].value += (start-left + 1); // 이 value에 들어가는건 최소, 즉 start에 떨어지는 운석개수.
		tree[node].cnt++; // start에 떨어지는 운석 외에 cnt 증가시켜두면 이따가 쿼리에서 target에서 길이만큼 더해주면 된다.
		return;
	}
	up(left, right, start, (start + end) / 2, node * 2); // 구간 찾아들어가기
	up(left, right, (start + end) / 2 + 1, end, node * 2 + 1);
}
ll query(ll tar, ll start, ll end, ll node) {
	if (end < tar || tar < start) return 0;
	else if (start==end) return tree[node].value; //리프는 앞에서 이미 start-left+1씩 더해졌으니 값만 반환 
	ll mid = (start + end) / 2;
	//cnt곱은 타겟에서 떨어진 만큼을 더해주는 수와 현재에서의 값을 더해주기, 그리고 나머지 밑에 값들 불러오기, 즉 target-left+1과 같다
	return query(tar, start, mid, node * 2) + query(tar, mid + 1, end, (node * 2) + 1) + tree[node].value + (tree[node].cnt*(tar- start)); 
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> n, siz = (1 << ((int)(log2(n) + 1))); i < n; cin >> tree[i + siz].value, i++);
	for (cin>>m,i = 0; i < m + k; i++) {
		cin >> a >> b;
		if (a == 1) {
			cin >> c;
			up(b + siz - 1, c + siz - 1, siz, siz * 2 - 1, 1);
		}
		else
			cout << query(b + siz - 1, siz, siz * 2 - 1, 1) << "\n";
	}
}
