// 1202 - 보석도둑 - 맥스힙

#include<iostream>
#include<queue>
#include<algorithm>
#include<utility>
using namespace std;
int n, k, i, j, ga[300000];
long long ret;
pair<int, int> p[300000];
priority_queue<int> q;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> n >> k; i < n; cin >> p[i].first >> p[i].second, i++);
	for (i = 0; i < k; cin >> ga[i++]);
	sort(p, p + n);
	sort(ga, ga + k);
	for (i =j= 0; i < k; i++) {
		for (; j < n&&p[j].first <= ga[i]; q.push(p[j++].second));
		if (!q.empty()) { ret += q.top(); q.pop(); }
	}
	cout << ret;
}