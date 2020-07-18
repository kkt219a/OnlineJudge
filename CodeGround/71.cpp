// samsung codeground - 71 - 정수 정렬하기(10000) 

#include <iostream>
#include <algorithm>
using namespace std;

long long int Answer;

int main()
{
	int T, i,n;
	long long int *a,b;
	setbuf(stdout, NULL);

	cin >> T;
	for(i = 0; i  < T; i++)
	{
		Answer = 0;
		cin>>n;
		a=(long long int*)malloc(sizeof(long long int)*n);
		for(int j=0;j<n;j++)
			cin>>a[j];
		
		sort(a,a+n);
		
		for(int j=0;j<n/2;j++){
			b=a[2*j]-a[2*j+1];
			Answer+=b;
		}
		
		if(n%2==1)
			Answer+=a[n-1];
		cout << "Case #" << i+1 << endl;
		cout << Answer << endl;
		free(a);
	}

	return 0;
}