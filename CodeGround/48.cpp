///////.///48 태준걱정 codeground

#include <iostream>

using namespace std;

int Answer;

int main(){
	int T,A,B,D;
	int N;
	cin >> T;
	
	for(int i= 0; i< T; i++)
	{
		Answer=0;
		cin>>A>>B>>D;
		N=A-B;
		
		if(D/N>=A)
			Answer=D/N-A+1;
		else
			Answer=D/N+1;
		
		cout << "Case #" << i+1 << endl;
		cout << Answer << endl;
	}

	return 0;
}
