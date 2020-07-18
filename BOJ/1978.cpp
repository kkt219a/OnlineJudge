// 1978 - 소수 찾기

#include <iostream>
using namespace std;


int main() {
	int N,a[100],count[100],count2=0;
	cin >> N;

	if (N < 101)
	{
		for (int i = 0; i < N; i++)
		{
			count[i] = 0;
			cin >> a[i];
			for (int j = 2; j < a[i]; j++)
			{
				if (a[i] % j == 0)  
					count[i]++; 
			}
			if (count[i] == 0&&a[i]!=1)
				count2++;
		}
	}
	cout << count2;

}
