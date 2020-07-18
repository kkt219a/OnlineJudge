// 1826 - 연료채우기 - 최대힙 

#include<iostream>
#include<queue>
#include<utility>
#include<algorithm>
using namespace std;
priority_queue<int> q;
pair<int, int> p[10000];
int n, l, f, i, ret;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> n; i < n; cin >> p[i].first >> p[i].second, i++);
	cin >> l >> f;
	sort(p, p + n);
	for (i = 0; f<l ;) {
		for (; p[i].first <= f&&i<n; q.push(p[i++].second)); //지금 연료보다 작은동안 모든 주유소들 연료 다 쑤셔넣기
		if (q.empty()) break; // 더이상 들릴 주유소가 없으면 있든 없든 멈추기
		ret++; // 들릴 주유소 있고
		f += q.top(); // 제일 연료 많이 주는곳을 택함
		q.pop(); // 그리고 그곳은 삭제
	}
	cout << (f < l ? -1 : ret); //도달못했으면 -1, 했으면 총 몇개 갔는지
}