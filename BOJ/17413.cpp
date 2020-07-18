// 17413 - 단어 뒤집기 2

#include<iostream>
#include<stack>
using namespace std;
char a[100001];
stack<char> s, o;
int i;
void pr() {
	while (!s.empty()) {
		cout << s.top();
		s.pop();
	}
}
int main() {
		cin.getline(a, 100001);
		for (; a[i] != '\0'; i++) {
			if (!o.empty()) {
				if (a[i] == '>')
					o.pop();
				cout << a[i];
			}
			else {
				if (a[i] == '<') {
					pr();
					cout << "<";
					o.push(a[i]);
				}
				else if (a[i] == ' ') {
					pr();
					cout << " ";
				}
				else
					s.push(a[i]);
			}
		}
		pr();
}
