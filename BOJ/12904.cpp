// 12904 - A와 B - 스트링 

#include<iostream>
#include<string>
using namespace std;
string a, b;
char c;
string re(string d) {
	string e;
	for (int i = d.length() - 1; i >= 0; e += d[i--]);
	return e;
}
int main() {
	cin >> a >> b;
	for (; a.length()<b.length();) {
		c = b.back();
		b.pop_back();
		if (c == 'B')
			b = re(b);
	}
	cout << (b.compare(a) == 0) ? 1 : 0;
}
