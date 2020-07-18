//백준 - 11648 - 지속
#include<iostream>
#include<string>
using namespace std;

int hi(int n){
	int c[9], d=1;
	for (int b = 0; n > 0; b++)
	{
		c[b] = n % 10;
		n = n / 10;
		d = d*c[b];
	}
	return d;
}

int main(){
	int b,c[6];
	cin >> c[0];
	for (b=0; c[b] >9;b++)
		c[b+1] = hi(c[b]);
	cout << b;
}