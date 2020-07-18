// 15651 - N과 M(3)
#include<iostream>
#include<vector>
using namespace std;
int n, m, v[9];
vector<int> v2;
void dfs(int b) {
	if (b == m) { //출력
		for (int j = 0; j < v2.size(); cout << v2[j] << " ", j++);
		cout << "\n";
	}
	else {
		for (int i = 1; i <= n; i++) {
				v2.push_back(i);
				dfs(b + 1);
				v2.pop_back();
		}
	}
}
int main() {
	cin >> n >> m;
	dfs(0);
}