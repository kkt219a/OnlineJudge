//11653 - 소인수분해

#include<iostream>
using namespace std;
int n, i;
int main() {
	for (cin >> n; n != 1;) {
		for (i = 2; i <= n; i++)
			if (n % i == 0) {
				n /= i;
				cout << i << "\n";
				break;
			}
	}
}