//백준 - 10886 - 0 = not cute / 1 = cute
#include<iostream>
using namespace std;
int k,n,m,i;
int main(){
	cin>>n;
	for(;i<n;i++){
		cin>>k;
		if(k)
			m++;
		else
			m--;
	}
	if(m<0)
		cout<<"Junhee is not cute!";
	else
		cout<<"Junhee is cute!";
	
}