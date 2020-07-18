//2445 - 별 찍기 -8
#include<iostream>
using namespace std;
int N,s,a,b,z;
int main(){
	cin>>N;
	s=N;
	for(a=1;a<=2*N-1;){
		for(b=0;b<a;b++)
			cout<<"*";
		for(b=0;b<2*s-2;b++)
			cout<<" ";
		for(b=0;b<a;b++)
			cout<<"*";
		z++;
		if(z<N)
			a++,s--;
		else if(z>=N){
			a--,s++;
		if(a<1)
			break;
		}
		cout << "\n";
	}
}