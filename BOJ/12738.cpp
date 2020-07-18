//백준 - 12738 - 가장 긴 증가하는 부분 수열 3
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n, i = 1, ip[1000001], j;
vector<int> v;
vector<int>::iterator v2;
int main() {
	for (v.push_back(-2000000000), cin >> n; i <= n; i++) {
		cin >> ip[i];
		if (v.back() < ip[i]){
			v.push_back(ip[i]);
			j++;
		}
		else {
			v2 = lower_bound(v.begin(), v.end(), ip[i]);
			*v2 = ip[i];
		}
	}
	cout << j;
}