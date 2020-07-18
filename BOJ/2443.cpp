//2443 - 별 찍기 -6
#include<iostream>
using namespace std;

int main()
{

	int a, b, c;
	int N;

	cin >> N;

	b = N;
	for (N; N>0; N--)
	{
		for (a = 0; a < N-b ; a++)
			cout << " ";
		for (c = 0; c < 2 * N - 1; c++)
			cout << "*";
		cout << "\n";
		
		b = b - 2;
	}

}