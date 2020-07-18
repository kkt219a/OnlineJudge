// 2739 - 구구단
#include<iostream>
using namespace std;

int main()
{
	int a, b;

	cin >> a;

	if (a >= 1 && a <= 9)
	{
		for (b = 1; b < 10; b++)
		{
			cout << a << " * " << b << " = " << a*b << "\n";
		}
	}
	return 0;
}