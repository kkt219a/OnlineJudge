//2309 - 일곱 난쟁이
#include<iostream>
#include<string>
using namespace std;

int main()
{
	int a[9], t = 0, a1, a2;
	for (int b = 0; b < 9; b++)
	{
		cin >> a[b];
		t += a[b];
	}
	t = t - 100;

	for (int b = 0; b < 9; b++)
		for (int c = 0; c < 9; c++)
			if (a[b] + a[c] == t)
			{
				a1 = a[b];
				a2 = a[c];
			}

	for(int b=0;b<9;b++)
		for (int c=b+1; c < 9; c++)
			if (a[b] > a[c])
			{
				int s;
				s = a[b];
				a[b] = a[c];
				a[c] = s;
			}

	for (int b = 0; b < 9; b++)
		if (a[b] != a1&&a[b] != a2)
			cout << a[b]<<"\n";
	

}