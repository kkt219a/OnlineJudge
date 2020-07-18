//백준 - 9093 - 단어 뒤집기
#include<iostream>
#include<stack>
using namespace std;
char a[1001];
stack<char> s;
int i, t;
int main() {
	for (cin >> t,cin.ignore(); t--; a[0] = '\0') {
		cin.getline(a, 1001);
		for (i=0; a[i] != '\0'; i++) {
			if (a[i] == ' ') {
				while (!s.empty()) {
					cout << s.top();
					s.pop();
				}
				cout << " ";
			}
			else s.push(a[i]);
		}
		while (!s.empty()) {
			cout << s.top();
			s.pop();
		}
		cout << "\n";
	}
}

