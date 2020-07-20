//17268 - 미팅의 저주 - 카탈란 수
#include<iostream>
#define m 987654321
using namespace std;
long long n, i = 3, a[5001] = { 1,1,2, }, j;
int main() {
	for (cin >> n; i <= n / 2; i++)
		for (j = 0; j < i; a[i] += ((a[j] * a[i - j-1])%m),a[i]%=m, j++);
	cout << a[n / 2];
}