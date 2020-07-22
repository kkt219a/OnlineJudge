//1463 - 1로 만들기 - DP
#include<iostream>
#include<algorithm>
using namespace std;
int n, a[1000001] = { 0,0,1,1, }, i = 4;
int main() {
	for (cin>>n; i <= n; i++) {
		a[i] =a[i - 1] + 1;
		a[i] = (i % 3 != 0) ? a[i] : min(a[i], a[i / 3] + 1);
		a[i] = (i % 2 != 0) ? a[i] : min(a[i], a[i / 2] + 1);
	}
	cout << a[n];
}