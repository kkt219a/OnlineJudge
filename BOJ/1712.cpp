// 1712- 손익분기점
#include<iostream>
int a, b, c, d; 
int main() {
	std::cin >> a >> b >> c;
	if (b >= c)
		std::cout << "-1";
	else {
		d = (a + b - c)/(c-b);
		if ((double)a + b < c)
			d--;
		std::cout <<d+2;
	}
}