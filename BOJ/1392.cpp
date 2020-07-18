//1392 - 노래악보

#include<iostream>
using namespace std;
int n, q, d[10001], i, p, j;
int main() {
	for (cin >> n >> q;i<n;i++)
		for (cin >> p; p--; d[j++] = i + 1);
	for (i = 0; i < q; cin >> p, cout << d[p]<<"\n", i++);
}