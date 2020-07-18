// samsung codeground - 3 - 시험 공부 

#include <iostream>
#include <algorithm>
using namespace std;

int Answer;

int main()
{
	int T, i, *a,k,N;
	setbuf(stdout, NULL);
	cin >> T;
	for(i=0;i<T;i++)
	{
		Answer = 0;
		cin>>N>>k;
		a=(int*)malloc(sizeof(int)*N);
		for(int j=0;j<N;j++)
			cin>>a[j];
		sort(a,a+N);
		for(int j=N-1;k>0;j--,k--)
			Answer+=a[j];
		
		
		
		cout << "Case #" << i+1 << endl;
		cout << Answer << endl;
		free(a);
	}

	return 0;
}