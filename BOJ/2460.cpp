//백준 - 지능형기차2 - 2460
#include<iostream>
using namespace std;

int x,y,k,s,m; //n내 , m타
int main(){
	while(k<10){
		cin>>x>>y;
		s+=(y-x);
		if(s>m)
			m=s;
		k++;
	}
	cout<<m;
}