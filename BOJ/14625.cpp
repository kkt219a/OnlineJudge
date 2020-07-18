// 14625 - 냉동식품
#include<iostream>
using namespace std;
int h1, h2, m1, m2, n, s, tm, tmp, tm2, fl, i;
int main() {
	cin >> h1 >> m1 >> h2 >> m2 >> n;
	tm = h1 * 100 + m1;
	tmp = h2 * 100 + m2;
	for (; tm <= tmp; tm++,fl=0) {
		if (tm % 100 == 60)
			tm += 40;
		for (tm2 = tm,i=0; i<4; i++, tm2 /= 10) {
			if (tm2 % 10 == n)
				fl = 1;
		}
		if (fl)
			s++;
	}
	cout << s;
}