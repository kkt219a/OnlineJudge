//백준 - 4375 - 1
#include<iostream>
using namespace std;
long long n, i, s;
int main() {
	for (;;cout << s<<"\n") {
		cin >> n;
		if (cin.eof()) break;
		for (s=1,i=1; i%n != 0; i = (i * 10 + 1)%n,s++);
	}
}