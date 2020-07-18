// 백준 - 피자판매 - 2632
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int s, m, n, i ,c, k;
vector<int> a, b, d, e;
vector<int>::iterator f;
int main() {
	for (cin >> s >> m >> n; i < m; cin >> c, a.push_back(c), k+=c, i++);
	for (d.push_back(k), i = 0,k=0; i < n; cin >> c, b.push_back(c),k+=c, i++);
	for (e.push_back(k), i = 0; i < m; i++) {
		for (c=0; c < m-1; c++) {
			k = i + c;
			if (k >= m)
				k -= m;
			if (c == 0)
				d.push_back(a.at(k));
			else
				d.push_back(d.back()+a.at(k));
		}
	}
	for (i = 0; i < n; i++) {
		for (c = 0; c < n-1; c++) {
			k = i + c;
			if (k >= n)
				k -= n;
			if (c == 0)
				e.push_back(b.at(k));
			else
				e.push_back(e.back() + b.at(k));
		}
	}
	d.push_back(0);
	e.push_back(0);
	sort(e.begin(), e.end());
	for(c=0,f=d.begin();f!=d.end();f++)
		c+=upper_bound(e.begin(), e.end(), s - *f) - lower_bound(e.begin(), e.end(), s-*f);
	cout << c;
}