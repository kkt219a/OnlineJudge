//백준 - 검증수 - 2475
#include<iostream>
using namespace std;

int a[5],k,s;
int main(){
	while(k<5){
		cin>>a[k];
		a[k]*=a[k];
		s+=a[k];
		k++;
	}
	cout<<s%10;

}