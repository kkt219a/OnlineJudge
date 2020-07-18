// 프로그래머스 레벨2

#include<iostream>
#include <string>
#include <vector>
#include<stack>
#include<algorithm>
using namespace std;
stack<char> s;
string ps;
//0: 균형잡힌(개수만맞음, 스택이 남을 때) 1:올바른( 서로 짝 다 맞을때, 스택이 빌때)
string solution(string p) {
	string answer = "", u = "", v = "", k = "";
	bool check, check2;
	check = 0;
	for (int i = 0; i < p.length(); i++) {
		if (p[i] == '(')
			s.push(p[i]);
		if (!s.empty()) {
			if (p[i] == ')'&&s.top() == '(')
				s.pop();
		}
	}
	if (s.empty()) // 비었으면 올바른.
		check = 1;
	for (; !s.empty(); s.pop());
	if (check||p.length()==0) // 올바르거나 빈 문자열이면 바로 반환, 1번 경우
		return p;
	else {
		check2=check = 0;
		for (int i = 0,y=0,d=0; i < p.length(); i++) {
			if (p[i] == '('&&!check) {
				u += p[i];
				s.push(p[i]);
				y++;
			}
			else if (p[i] == ')' && !check) {
				u += p[i];
				if (!s.empty())
					s.pop();
				else
					check2 = 1;
				d++;
			}
			if (check)
				v += p[i];
			if (y == d)
				check = 1;

		}
		if (s.empty()&&check2!=1) {
			u += solution(v);
			return u;
		}
		else {
			for (; !s.empty(); s.pop());
			k = k + '(' + solution(v) + ')';
			u=u.substr(1, u.size() - 2);
			for (int l = 0; l < u.size(); l++) {
				if (u[l] == '(')
					u[l] = ')';
				else
					u[l] = '(';
			}
			k += u;
			return k;
		}
	}
}

int main() {
	cin >> ps;
	cout<<solution(ps);
}