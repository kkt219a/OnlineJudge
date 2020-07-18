//백준 - 곱셈 - 2588
#include<iostream>
using namespace std;
int a,b,c[3],i,s,d=1;
int main(){
	cin>>a>>b;
	for(;i<3;i++){
		c[i]=b%10;
		b/=10;
	}
	for(i=0;i<3;i++){
		cout<<a*c[i]<<"\n";
		s+=a*c[i]*d;
		d*=10;
	}
	cout<<s;
}