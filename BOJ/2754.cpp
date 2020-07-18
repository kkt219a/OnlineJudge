//백준 - 학점계산 - 2754
#include <iostream>
#include <string>
using namespace std;


int main()
{
	double a[13] = { 4.3,4.0,3.7,3.3,3.0,2.7,2.3,2.0,1.7,1.3,1.0,0.7,0.0 };
	string c,b[13] = { "A+","A0","A-","B+","B0","B-","C+","C0","C-","D+","D0","D-","F" };
	cin >> c;
	for (int i = 0; i < 13; i++) {
		if (c == b[i]) {
			cout << fixed;
			cout.precision(1);
			cout << a[i];
		}
	}
}
