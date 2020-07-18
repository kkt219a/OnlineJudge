//10820 - 문자열 분석

#include<iostream>
using namespace std;
char a[101];
int i, b, c, d, e;
int main() {
	for (;;a[0]='\0',d=0,b=0,c=0,e=0) {
		cin.getline(a,101);
		if (cin.eof())
			break;
		for (i = 0; a[i] != '\0'; i++) {
			if (a[i] == 32)
				e++;
			else if (a[i] < 58)
				d++;
			else if (a[i] < 91)
				c++;
			else
				b++;
		}
		cout << b << " " << c << " " << d << " " << e << "\n";
	}
}