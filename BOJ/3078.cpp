//3078 - 좋은친구 - 큐 - 다시

#include<iostream>
#include<queue>
#include<string.h>
using namespace std;
int n, i, cnt, k, le, ret, leng[21];
char a[21];
queue<int> q;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> n>>k; i < n; i++) {
		cin >> a;
		le = strlen(a);
		q.push(le);
		ret += (leng[le]++);
		if (i >= k) { leng[q.front()]--; q.pop(); }
	}
	cout << ret;
}