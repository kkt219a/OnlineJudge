//백준 - 7453 - 합이 0인 네 정수
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
vector<int> a1, a2, a3, a4,v1,v2;
vector<int>::iterator e, f;
int n, a, b, c, d;
long long cnt;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(false);
	for (cin >> n; n--;) {
		cin >> a >> b >> c >> d;
		a1.push_back(a);
		a2.push_back(b);
		a3.push_back(c);
		a4.push_back(d);
	}
	for (e = a1.begin(); e != a1.end(); e++)
		for (f = a2.begin(); f != a2.end(); f++)
			v1.push_back(*e + *f);
	for (e = a3.begin(); e != a3.end(); e++)
		for (f = a4.begin(); f != a4.end(); f++)
			v2.push_back(*e + *f);
	sort(v2.begin(), v2.end());
	for (e = v1.begin(); e != v1.end(); e++)
		cnt+=upper_bound(v2.begin(), v2.end(), -(*e))-lower_bound(v2.begin(), v2.end(), -(*e));
	cout << cnt;
}