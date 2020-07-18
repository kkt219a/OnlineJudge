// 백준 - 1920 - 수 찾기 - 이진탐색

#include<iostream>
#include<algorithm>
using namespace std;
int n, a[100001], i, k, m;
int main() {
	for (cin >> n; i < n; cin >> a[i++]);
	for (sort(a, a + n), cin >> m,i=0; i < m; cin >> k, cout<<binary_search(a, a + n, k) << "\n",i++);
}