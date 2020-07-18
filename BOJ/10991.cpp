//백준 - 10991 - 별찍기16
#include<iostream>
using namespace std;
int n,i,j;

int main(){
	cin>>n;
	for(;i<n;i++){
		for(j=n-1;j>i;j--)
			cout<<" ";
		for(j=0;j<=i;j++)
			cout<<"* ";
		cout<<"\n";
	}
}