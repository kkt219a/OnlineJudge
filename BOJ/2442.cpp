//2442 - 별 찍기 -5
#include<iostream>
using namespace std;

int main()
{

	int a, b, c;
	int N;

	cin >> N;


	for (b=1; b<=N; b++)
	{
		for (a=0; a < N-b; a++)
			cout << " ";
		for (c = 0; c < 2 * b - 1; c++)
			cout << "*";	
		cout << "\n";
	}

}

