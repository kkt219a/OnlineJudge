// 1181 - 단어정렬

#include<iostream>
#include<string>
#include<algorithm>
using namespace std;
int n, i;
string b[20000], f = "";
bool c(string a, string b) {
	if (a.length() == b.length())
			return a < b;
	return a.length() < b.length();
}
int main() {
	for (cin >> n; i < n; i++)
		cin >> b[i];
	sort(b, b + n, c);
	for (i = 0; i < n; i++) {
		if (f.compare(b[i]) == 0)
			continue;
		cout << b[i] << "\n";
		f = b[i];
	}
}