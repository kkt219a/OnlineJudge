//1541 - 잃어버린 괄호

#include<iostream>
#include<string.h>
using namespace std;
char a[52];
int i, c, d = 1, s;
int main() {
	for (cin >> a,i=strlen(a); i--;) {
		if (a[i] != 45&&a[i]!=43) {
			c+=(a[i]-48) * d;
			d *= 10;
		}
		else {
			if (a[i] == 45) {
				s += (-c);
				c = 0;
			}
			d = 1;
		}
	}
	if (a[0]>47)
		s += c;
	cout << s;
}