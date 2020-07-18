// 14247 - 나무 자르기

#include<iostream>
#include<utility>
#include<algorithm>
using namespace std;
int n, a[100000], i;
pair<int, int> c[100000];
long long s;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	for (cin >> n; i < n; cin >> a[i++]);
	for (i=0; i < n;cin>>c[i].first, c[i].second = i, i++);
	for (sort(c, c + n), i = 0; i < n; s += a[c[i].second] + c[i].first*i, i++);
	cout << s;
}