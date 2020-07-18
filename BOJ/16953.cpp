// 16953 - A → B 

#include<iostream>
using namespace std;
int a, b, c = 1;
int main() {
	for (cin >> a >> b; a < b; c++){
		if (!(b % 2)) b /= 2;
		else if (b % 10 == 1) b /= 10;
		else if (b % 2 == 1) break;
	}
	c = (a == b) ? c : -1;
	cout << c;
}