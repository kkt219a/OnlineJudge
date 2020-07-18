// 2749 - 피보나치 수3
#include<iostream>
using namespace std;
long long a[1500003] = { 0,1, }, n;
int i;
int main() {
	for (cin >> n; i < 1500000; a[i+2] = (a[i] + a[i+1]) % 1000000, i++);
	cout << a[n % 1500000];
}