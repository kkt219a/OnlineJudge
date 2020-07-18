// 17103  - 골드바흐 파티션

#include<iostream>
#include<vector>
using namespace std;
int t, n, a[1000001], i, j, c;
vector<int> v;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (i = 2; i < 500001; i++)
		if(a[i]!=1)
			for (j = 2; i*j < 1000001; a[i*j] = 1, j++);
	for (i = 2; i < 1000001; i++)
		if (!a[i])
			v.push_back(i);
	for (cin >> t; t--; cout << c << "\n", c = 0) {
		cin >> n;
		for (i = 0; v[i] <= n / 2; i++)
			if (!a[n-v[i]])
				c++;
	}
}