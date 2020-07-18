// 1016-제곱ㄴㄴ수-다른풀이
#include<iostream>
#include<math.h>
using namespace std;
long long a, b, arr[1000001], k, i, j, t;
int cnt;
int main() {
	std::cin >> a >> b;
	for (j = 0; a <= b; a++, j++) {
		arr[j] = a;
	}
	t = arr[0];
	for (i = 2; i <= sqrt(b); i++) {
		k = t % (long long)pow(i, 2);
		if(k!=0)
			k = (long long)pow(i, 2) - k;
		for (; k <= j - 1; arr[k] = 0, k += pow(i, 2)) { }
	}
	for (i = 0; i < j; i++)
		if (arr[i] != 0)
			cnt++;
	cout << cnt;
}