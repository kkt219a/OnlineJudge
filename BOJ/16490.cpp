//BOJ - 16490 - 외계인의 침투 - 원주각 성질, 다시는 굳이..

#include<iostream>
#include<math.h>
using namespace std;
int main() {
	int a = 0, t = 0, bc = 0;
	cin >> a >> t;
	bc = (int)pow(a, 2) - (int)pow(t, 2);
	cout << bc;
}