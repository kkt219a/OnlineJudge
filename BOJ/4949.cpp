//백준 - 4549 - 균형잡힌 세상
#include<iostream>
#include<stack>
#include<string.h>
using namespace std;
char a[103];
int i, j;
stack<char> b;
int main() {
	for (;;i++,a[0]='\0') {
		cin.getline(a, 103);
		if (a[0] == '.'&&strlen(a) == 1)
			break;
			for (j = 0; a[j] != '\0'; j++) {
				if (a[j] == '[' || a[j] == '(')
					b.push(a[j]);
				else if (a[j] == ']' || a[j] == ')') {
					if (!b.empty()) {
						if ((a[j] == ']'&&b.top() == '[') || (a[j] == ')'&&b.top() == '('))
							b.pop();
						else
							b.push(a[j]);
					}
					else
						b.push(a[j]);
				}
			}
		if (b.empty())
			cout << "yes\n";
		else
			cout << "no\n";
		while (!b.empty())
			b.pop();
	}
}