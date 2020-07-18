//백준 - 세 수 - 10817
#include <iostream>
using namespace std;

int main()
{

	int A, B, C;
	cin >> A  >>B>>C;

	if (A < 1 || A>100||B<1||B>100||C<1||C>100)
	{
		cout << "Bye";
	}

	else
	{
		if (A >B&&A > C&&B >= C) 
			cout << B; 
		else if (B >= A&&C > A&&C > B) 
			cout << B;
		else if (A > B&&A >=C&&C > B) 
			cout << C;
		else if (B > A&&B >= C&&C > A) 
			cout << C;
		else if (B > A&&B > C&&A >= C) 
			cout << A;
		else if (C > A&&C > B&&A >= B) 
			cout << A;
		else if (C < A&&C < B&&A <= B) 
			cout << A;
		else if (C < A&&C < B&&A >= B) 
			cout << B;
		else if (A==B&&B==C&&A==C)
			cout << B;
	}
	return 0;
}
