//BOJ - 16785 - ソーシャルゲーム

#include<iostream>
using namespace std;
int a, b, c, sum, cnt;
int main() {
	cin >> a >> b >> c;
	while (sum < c) {
		sum += a;
		cnt++;
		if (cnt % 7 == 0)
			sum += b;
	}
	cout << cnt;
}