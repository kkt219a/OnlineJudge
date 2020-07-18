//백준 - 숫자의 개수 - 2577
#include<iostream>
using namespace std;

int main()
{
	int A, B, C, D;
	int a, b[10] = { 0};

	cin >> A >> B >> C;
	if (A >= 100 && A < 1000 && B >= 100 && B < 1000 && C >= 100 && C < 1000)
	{
		D = A*B*C;


		for (D; D >0; D=D/10)
		{

			if (D % 10 == 0)
				b[0]++;
			else if (D % 10 == 1)
				b[1]++;
			else if (D % 10 == 2)
				b[2]++;
			else if (D % 10 == 3)
				b[3]++;
			else if (D % 10 == 4)
				b[4]++;
			else if (D % 10 == 5)
				b[5]++;
			else if (D % 10 == 6)
				b[6]++;
			else if (D % 10 == 7)
				b[7]++;
			else if (D % 10 == 8)
				b[8]++;
			else if (D % 10 == 9)
				b[9]++;
			

		}



		for (a = 0; a < 10; a++)
		{
			cout << b[a] << "\n";
		}
	}


}
