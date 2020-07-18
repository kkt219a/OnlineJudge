// 2798-블랙잭-브루트포스

#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n, m, a[100], i, j, k;
vector<int> v;
int main() {
	for (cin >> n >> m, i = 0; i < n; i++)
		cin >> a[i];
	for (i = 0; i < n - 2; i++)
		for (j = i + 1; j < n - 1; j++)
			for (k = j + 1; k < n; k++)
				if (a[i] + a[j] + a[k] <= m)
					v.push_back(a[i] + a[j] + a[k]);
	sort(v.begin(), v.end());
	cout << v.back();
}