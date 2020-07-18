//백준 - 음계 - 2920
#include<iostream>
using namespace std;
int i=1,a[9],s,ds,j=8;
int main(){
	for(;i<9;i++,j--){
		cin>>a[i];
		if(a[i]==i)
			s++;
		else if(a[i]==j)
			ds++;
	}
	if(s==8)
		cout<<"ascending";
	else if(ds==8)
		cout<<"descending";
	else
		cout<<"mixed";
	
}