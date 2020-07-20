//2014 - 소수의 곱 - 우선순위 큐

#include<iostream>
#include<queue>
using namespace std;
typedef long long ll;
priority_queue<ll,vector<ll>, greater<ll> > pq;
ll ar[100], k, n, i, j, nw;
int main() {
	for (cin >> k >> n; i < k; cin >> ar[i],pq.push(ar[i++]));
	for (i = 0; i < n; i++) {
		nw = pq.top();
		pq.pop();
		for (j = 0; j < k; j++) {
			pq.push(ar[j] * nw);
			if (nw % ar[j] == 0)
				break;
		}
	}
	cout << nw;
}