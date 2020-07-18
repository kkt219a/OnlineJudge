//1406 - 에디터

#include<iostream>
#include<list>
#include<string>
#include<string.h>
using namespace std;
list<char> a;
list<char>::iterator e;
string b;
char d[4];
int c, i;
int main() {
	for (cin >> b>>c; i < b.length(); a.push_back(b[i]), i++);
	for (e=a.end(),c++; c--; d[0] = '\0') {
		cin.getline(d, 4);
		if (d[1] == '\0') {
			if (d[0] == 'L'&&e != a.begin())
				e--;
			else if (d[0] == 'D'&&e != a.end())
				e++;
			else if (d[0] == 'B'&&e != a.begin()) {
				e--;
				e = a.erase(e);
			}
		}
		else
			a.insert(e,d[2]);
	}
	for (e = a.begin(); e != a.end(); cout << *e, e++);
}
