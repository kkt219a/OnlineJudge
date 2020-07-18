//1629 - 곱셈

#include<iostream>
using namespace std;
long long a, b, c, i=1, d[32], j=1;
int main() {
	cin >> a >> b >> c;
	for (d[0] = a % c; i < 32; d[i] = d[i - 1] * d[i - 1] % c,i++);
	for (i = 0,j=1; b != 0; b /= 2,i++,j%=c)
		if (b % 2)
			j *=d[i];
	cout << j;
}