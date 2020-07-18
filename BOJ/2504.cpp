// 2504 - 괄호의 값 - 스택

#include<iostream>
#include<string.h>
#include<stack>
using namespace std;
char a[31];
int i, idx, v, ans, v2;
stack<char> s1;
stack<int> s2[30];
int main() {
	for (cin >> a; i < strlen(a); i++) {
		if (a[i] == '('||a[i]=='[') { idx++; s1.push(a[i]); }
		else if(!s1.empty()&&(a[i]==')'||a[i]==']')){
			if (s1.top() == '('&&a[i] == ')')
				v = 2;
			else if (s1.top() == '['&&a[i] == ']')
				v = 3;
			else break;
			if (!s2[idx].empty()) {
				for (v2=0; !s2[idx].empty(); v2 += s2[idx].top(), s2[idx].pop());
				v *= v2;
			}
			s2[--idx].push(v);
			s1.pop();
		}
		else break;
	}
	if (s1.empty()&&i==strlen(a))
		for (; !s2[0].empty(); ans += s2[0].top(), s2[0].pop());
	cout << ans;
}
