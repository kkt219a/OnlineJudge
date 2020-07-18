// 1966 - 프린터 큐

#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;
int t, n, m, i, d[100];
queue< pair<int,int> > a;
bool e(int a, int b) {
	return a > b;
}
int main() {
	for (cin >> t; t--;) {
		for (cin >> n >> m, i = 0;i<n;i++) {
			cin >> d[i];
			a.push(pair<int,int> (i,d[i]));
		}
		sort(d, d + n,e);
		for (i = 0;;) {
			if (d[i] == a.front().second) {
				if (a.front().first == m)
					break;
				i++;
				a.pop();
			}
			else {
				a.push(a.front());
				a.pop();
			}
		}
		cout << i + 1 << "\n";
		while (!a.empty())
			a.pop();
	}
}