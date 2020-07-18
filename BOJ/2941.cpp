//백준 - 크로아티아 알파벳 - 2941
#include<iostream>
#include<string>
using namespace std;
string b;
int i, n;
int main(){
	cin >> b;
	for (; i < b.length(); i++) {
		n++;
		if (b[i] == 'c') {
			if (b[i + 1] == '=' || b[i + 1] == '-') { i++; }
		}
		else if (b[i] == 'd') {
			if (b[i + 1] == '-')
				i++;
			else if (b[i + 1] == 'z'&&b[i + 2] == '=')
				i += 2;
		}
		else if (b[i] == 'l' || b[i] == 'n') {
			if (b[i + 1] == 'j') {
				i++;
			}
		}
		else if (b[i] == 's' || b[i] == 'z') {
			if (b[i + 1] == '=') {
				i++;
			}
		}
	}
	cout << n;
}