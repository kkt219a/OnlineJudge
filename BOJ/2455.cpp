//백준 - 지능형 기차 - 2455
#include<iostream>
using namespace std;

int x,y,k,s,m; //n내 , m타
int main(){
	while(k<4){
		cin>>x>>y;
		s+=(y-x);
		if(s>m)
			m=s;
		k++;
	}
	cout<<m;
}