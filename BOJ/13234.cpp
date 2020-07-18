//백준 - 13234 - George Boole
#include<iostream>
#include<string>
using namespace std;
string a, b, c;
bool d, e, f;
int main() {
	cin >> a >> b >> c;
	if (!a.compare("true"))
		d = 1;
	else
		d = 0;
	if (!c.compare("true"))
		e = 1;
	else
		e = 0;
	if (!b.compare("OR"))
		f = (d || e);
	else
		f = (d&&e);
	if (f)
		cout << "true";
	else
		cout << "false";
}