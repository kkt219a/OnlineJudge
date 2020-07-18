// 16480 - 내심과 외심은 사랑입니다-  R(R-2r)=d^2

#include<iostream>
#include<algorithm>
#include<math.h>
using namespace std;
long long r, R, d;
int main() {
	cin >> R >> r;
	d = R * (R - 2 * r);
	cout << d;
}