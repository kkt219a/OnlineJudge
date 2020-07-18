//3392 - 화성지도 - 세그먼트트리 + 라인 스위핑

#include<iostream>
#include<algorithm>
#include<math.h>
using namespace std;
struct point { int x, y1, y2, v; }; // v는 시점이면 1, 종점이면 -1
bool cmp(point a, point b) { return a.x < b.x; }
point p[20000];
int a, b, c, d, i, seg[200000], cnt[200000], siz, ans, n, prevs; // cnt는 y의 길이를 알기 위해, seg는 실제 y의 구간길이
void update(int left, int right, int start, int end, int node, int val) {
	if (end < left || right < start) return; // 아예 벗어나는 애들은 끝내기
	if (start >= left && end <= right) cnt[node] += val; // 구간에 속하면 그 구간에 있다고 표시
	else { // 안속하면 더 내부로 들어가기
		update(left, right, start, (start + end) / 2, node * 2, val);
		update(left, right, (start + end) / 2 + 1, end, node * 2 + 1, val);
	}
	if (cnt[node]) seg[node] = end - start + 1; // 구간에 있으면 이 구간 길이만큼 seg에 표시
	else { // 구간에 값이 없는데
		if (start == end) seg[node] = 0; // 시점 종점이 같으면 y 길이가 같으니 0이다
		else seg[node] = seg[node * 2] + seg[node * 2 + 1]; // 같지 않은데 여기에 없었다면 자식 두개의 합
	}
}
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	for (cin >> n; i < n; cin >> a >> b >> c >> d, p[i] = { a,b,d - 1,1 }, p[i + n] = { c,b,d - 1,-1 }, i++);
	sort(p, p + 2*n, cmp);
	for (i = 0, siz = (1 << ((int)log2(30000) + 1)); i < 2 * n; i++) {
		if (i) ans += (p[i].x - prevs) * seg[1];
		update(siz + p[i].y1, siz + p[i].y2, siz, siz * 2 - 1, 1, p[i].v);
		prevs = p[i].x;
	}
	cout << ans;
}