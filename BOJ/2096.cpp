// 2096 - 내려가기

#include<iostream>
#include<algorithm>
using namespace std;
int n, i, a, b, c, mi[3], ma[3], now[3], tmp[3], j;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> n; i < n; i++) {
		cin >> now[0] >> now[1] >> now[2];
		tmp[0] = now[0] + min(mi[0], mi[1]);
		tmp[1] = now[1] + min(mi[0], min(mi[1], mi[2]));
		tmp[2] = now[2] + min(mi[1], mi[2]);
		for (j = 0; j < 3; mi[j] = tmp[j], j++);
		tmp[0] = now[0] + max(ma[0], ma[1]);
		tmp[1] = now[1] + max(ma[0], max(ma[1], ma[2]));
		tmp[2] = now[2] + max(ma[1], ma[2]);
		for (j = 0; j < 3; ma[j] = tmp[j], j++);
	}
	cout << max(max(ma[0], ma[1]), ma[2]) << " " << min(min(mi[0], mi[1]), mi[2]);

}