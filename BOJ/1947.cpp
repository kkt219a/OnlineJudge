//1947 - 선물 전달 - DP(완전순열, 교란순열)
#include<iostream>
using namespace std;
long long a[1000001] = { 0,0,1, }, n, i = 3;
int main() {
	for (cin >> n; i <= n; a[i] = (i - 1) * (a[i - 2] + a[i - 1]) % 1000000000, i++);
	cout << a[n];
}