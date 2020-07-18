// BRACKETS2 - 짝이 맞지 않는 괄호 - 스택 이용

#include<iostream>
#include<stack>
#include<string>
using namespace std;
string a;
int k, i, c;
int gwal(string b) {
	string open("({["), close(")}]");
	stack<char> s;
	for (int i = 0; i < b.length(); i++) {
		if (open.find(b[i]) != -1)
			s.push(b[i]);
		else {
			if (s.empty())
				return 0;
			else if (open.find(s.top()) != close.find(b[i]))
				return 0;
			s.pop();
		}
	}
	return s.empty();
}
int main() {
	for (cin >> c; c--;) {
		cin >> a;
		if(gwal(a))
			cout << "YES\n";
		else
			cout << "NO\n";
	}
}