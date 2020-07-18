//백준 - 6603 - 로또
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int n, m, p = 1, k[13], j, vi[13];
vector<int> v;
void per(int s, int t) {
	if (s == 6) {
		for (p = 0; p < v.size(); cout << v[p++] << " ");
		cout << "\n";
	}
	else
		for (int i = t + 1; i <= n; i++) {
			if (vi[i]) continue;
			vi[i] = 1;
			v.push_back(k[i - 1]);
			per(s + 1, i);
			vi[i] = 0;
			v.pop_back();
		}
}
int main() {
	for (cin >> n;;cin>>n) {
		if (n == 0)
			break;
		for (j = 0; j < n; cin >> k[j++]);
		per(0,0);
		for (cout<<"\n",v.clear(),j = 0; j < n; k[j] = 0,vi[j++]=0);
	}
}