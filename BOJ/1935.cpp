// 1935 - 후위 표기식2

#include<iostream>
#include<stack>
#include<stdio.h>
using namespace std;
char a[101];
int n, i;
double b[26], c, d;
stack<double> s;
int main() {
	for (cin >> n >> a; i < n; cin >> b[i++]);
	for (i = 0; a[i] != '\0'; i++) {
		if (a[i]<48) {
			c = s.top();
			s.pop();
			d = s.top();
			s.pop();
			if (a[i] == 42)
				s.push(d*c);
			else if (a[i] == 43)
				s.push(d + c);
			else if (a[i] == 45)
				s.push(d - c);
			else
				s.push(d / c);
		}
		else
			s.push(b[a[i]-65]);
	}
	printf("%.2lf", s.top());
}
