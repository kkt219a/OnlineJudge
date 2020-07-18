//백준 - 벌집 - 2292
#include<iostream>
using namespace std;

int n,s=1,c;
int main(){
	cin>>n;
	
	if(n==1)
		cout<<n;
	else{
		for(int i=1;s<n;i++,c++)
			s+=i*6;
		cout<<++c;
	}
}