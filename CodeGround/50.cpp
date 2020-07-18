// samsung codeground - 50 - 스타벅스
 
#include<iostream>
#include<stdlib.h> 
using namespace std;

char ans;

int main()
{
	int T,M,N,K;
	int *c,*p;
	int sum;

	cin >> T;
	
	for(int i=0;i<T;i++)
	{
		cin>>N>>M>>K;
		c=(int*)malloc(sizeof(int)*N);
		p=(int*)malloc(sizeof(int)*M);
		ans = 'N';
		sum=0;
		
		for(int i=0;i<N;i++)
			cin>>c[i];
		for(int i=0;i<M;i++)
			cin>>p[i];
		for(int i=0;i<N;i++)
			sum+=p[c[i]-1];

		
		if(sum<=K)
			ans='Y';
		
		cout << "Case #" << i+1 << endl;
		cout << ans << endl;
		free(c);
		free(p);
	}

	return 0;
}