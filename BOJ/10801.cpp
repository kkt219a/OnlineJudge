//백준 - 10801 - 카드게임
#include<iostream>
using namespace std;
int a[20],i,j;
int main(){
	for(;i<20;i++)
		cin>>a[i];
	for(i=0;i<10;i++){
		if(a[i]<a[i+10])
			j--;
		else if(a[i]==a[i+10]){}
		else
			j++;
	}
	if(j<0)
		cout<<'B';
	else if(j==0)
		cout<<"D";
	else
		cout<<'A';
}