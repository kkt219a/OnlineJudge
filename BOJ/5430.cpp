//백준 - 5430 - AC
#include<iostream>
#include<algorithm>
#include<deque>
#include<string>
#include<stdlib.h>
using namespace std;
deque<int> p;
deque<int>::iterator ch;
string s,k,r;
int t,i,n;
bool flag=0,err=0;
int main(){
	for (cin >> t; t--; p.clear(),flag=0,err=0) {
		r = k = s = "";
		cin >> s >> n >> r;
			r = r.substr(1, r.length() - 2); 
			for (i = 0; i < r.length(); i++) {
				if (r[i] == ',') {
					p.push_back(atoi(k.c_str()));
					k = "";
					continue;
				}
				k += r[i];
			}
			p.push_back(atoi(k.c_str()));
			if (r.length() < 2 && r[0]=='\0')
				p.pop_back();

			for (i = 0; i < s.length(); i++) {
				if (s[i] == 'R') {
					if (!flag)
						flag = 1;
					else
						flag = 0;
				}
				else if (s[i] == 'D') {
					if (!p.empty()) {
						if (flag)
							p.pop_back();
						else
							p.pop_front();
					}
					else {
						err = 1;
						break;
					}
				}
			}
		if (!err) {
			cout << "[";
			if (flag) {
				for (deque<int>::reverse_iterator riter(p.rbegin()); riter!=p.rend();riter++){
					cout << *riter;
					if (riter + 1 != p.rend())
						cout << ",";
				}
			}
			else {
				for (ch = p.begin(); ch != p.end(); ch++) {
					cout << *ch;
					if (ch + 1 != p.end())
						cout << ",";
				}
			}
			cout << "]\n";
		}
		else
			cout << "error\n";
	}
}
