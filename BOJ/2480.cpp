// 2480- 주사위 세개
#include<iostream>
#include<algorithm>
int a,b,c,t,d,e,f;
int p(int a, int b) {
	t = std::max(t, a);
	if (a == b)
		return 1;
	return 0;
}
int main() {
	std::cin >> a >> b >> c;
	d=p(a,b);
	e=p(b,c);
	f=p(c,a);
	if (d+e+f == 3)
		t = 10000 + a * 1000;
	else if (d + e + f == 1) {
		if (d == 1)t = a;
		if (e == 1)t = b;
		if (f == 1)t = c;
		t = 1000 + t * 100;
	}
	else
		t = t * 100;
	std::cout << t;
}