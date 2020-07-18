// 백준 - 1918 - 후위 표기식
#include<iostream>
#include<string>
#include<stack>
using namespace std;
string a;
int i;
stack<char> s;
int main() {
	cin >> a;
	for (; a[i] != '\0'; i++) {
		if (a[i] > 48)
			cout << a[i];
		else{
			switch (a[i]){
			case '(':
				s.push(a[i]);
				break;
			case '*': case '/':
				while (!s.empty() && (s.top() == '*' || s.top() == '/')){
					cout<<s.top();
					s.pop();
				}
				s.push(a[i]);
				break;
			case '+': case '-':
				while (!s.empty() && s.top() != '('){
					cout<<s.top();
					s.pop();
				}
				s.push(a[i]);
				break;
			case ')':
				while (!s.empty() && s.top() != '('){
					cout<<s.top();
					s.pop();
				}
				s.pop();
				break;
			}
		}
	}
	while (!s.empty()) {
		cout << s.top();
		s.pop();
	}
}