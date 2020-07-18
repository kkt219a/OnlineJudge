// 1977 - 완전제곱수

#include <iostream>
using namespace std;


int main() {
	int a[100], m, n, sum = 0;

	cin >> m >> n;
	for (int i = 0; i < 100; i++)
	{
		a[i] = (i + 1)*(i + 1);
		if (a[i] < m || a[i] > n)
			a[i] = 0;
		sum = sum + a[i];
	}
	if (sum == 0)
		cout << "-1";
	else
	{
		cout << sum<<"\n";
		for (int i = 0; i < 100; i++)
		{
			if (a[i] != 0)
			{
				cout << a[i];
				break;
			}
		}
	}
}
