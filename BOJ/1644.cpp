//1644 - 소수의 연속합 - 에라+투포인터

#include<iostream>
#include<vector>
using namespace std;
int n, i, j, sum, ret;
bool a[4000001];
vector<int> v;
int main() {
	for (cin >> n, i = 2; i < n / 2 + 1; i++) {
		if (a[i]) continue;
		for (j = 2; i*j < n + 1; a[i*j] = 1, j++);
	}
	for (i = 2; i < n + 1; i++) if (!a[i]) v.push_back(i);
	for (i = 0, j = 0; i < v.size();) {
		if (sum == n) ret++;
		if(sum<n&&j<v.size()) sum += v[j++];
		else sum -= v[i++];
	}
	cout << ret;
}