// 2304 - 창고 다각형 - 다시

#include<iostream>
#include<algorithm>
using namespace std;
int n, a, b, c, d, nidx = 1001, xidx = -1, arr[1001], e;
int main() {
	for (cin >> n; n--; arr[a] = b) {
		cin >> a >> b;
		nidx = min(nidx, a);
		xidx = max(xidx, a);
		if (b > d) { c = a; d = b; }
	}
	for (e=b=0,a = nidx; a < c;e = max(arr[a], e),b+=e, a++);
	for (e=0,a = xidx; a > c;e = max(arr[a], e),b+=e, a--);
	cout << b + d;
}